package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.User;
import com.challenge.odonto_prev.domain.dto.UserDTO;
import com.challenge.odonto_prev.domain.dto.authDTO.LoginRequestDTO;
import com.challenge.odonto_prev.domain.dto.authDTO.LoginResponseDTO;
import com.challenge.odonto_prev.domain.dto.authDTO.RegisterRequestDTO;
import com.challenge.odonto_prev.domain.dto.authDTO.RegisterResponseDTO;
import com.challenge.odonto_prev.infra.security.TokenService;
import com.challenge.odonto_prev.services.exceptions.InvalidCredentialsException;
import com.challenge.odonto_prev.services.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userService.loadUserByUsername(username);
    }

    @Transactional(readOnly = true)
    public LoginResponseDTO login(LoginRequestDTO authDTO) {
        User user = (User) this.loadUserByUsername(authDTO.email());
        if (passwordEncoder.matches(authDTO.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return new LoginResponseDTO(user.getEmail(), token);
        } else {
            throw new InvalidCredentialsException("Senha incorreta!!");
        }
    }

    @Transactional
    public RegisterResponseDTO signup(RegisterRequestDTO authDTO) {
        this.userService.findByEmail(authDTO.email())
                .ifPresent(user -> {
                    throw new UserAlreadyExistsException("Conta já existente com este email.");
                });

        this.validatePassword(authDTO.password(), authDTO.confirmPassword());

        String encryptedPassword = passwordEncoder.encode(authDTO.password());

        UserDTO user = switch (authDTO.role()) {
            case DENTISTA -> {
                if (authDTO.cro() == null || authDTO.cro().isBlank()) {
                    throw new InvalidCredentialsException("O CRO é obrigatório para o papel de Dentista.");
                }
                yield new UserDTO(new User(authDTO.name(), authDTO.email(), encryptedPassword, authDTO.cro(), authDTO.role()));
            }
            case ATENDENTE -> {
                if (authDTO.cro() != null) {
                    throw new InvalidCredentialsException("A atendente não pode ter CRO.");
                }
                yield new UserDTO(new User(authDTO.name(), authDTO.email(), encryptedPassword, authDTO.role()));
            }
            default -> throw new InvalidCredentialsException("Papel de usuário inválido.");
        };

        user = this.userService.insert(user);
        return new RegisterResponseDTO(user.getEmail(), user.getName());
    }

    @Transactional
    public void forgotPassword(String email, String newPassword, String confirmNewPassword) {
        User user = (User) this.loadUserByUsername(email);
        this.validatePassword(newPassword, confirmNewPassword);
        user.setPassword(passwordEncoder.encode(newPassword));
        this.userService.insert(new UserDTO(user));
    }

    private void validatePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new InvalidCredentialsException("As senhas não coincidem !!");
        }
    }
}
