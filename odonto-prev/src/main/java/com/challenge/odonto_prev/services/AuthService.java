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
    @Autowired
    private EmailService emailService;

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

        String encryptedPassword = passwordEncoder.encode(authDTO.password());

        UserDTO user = switch (authDTO.role()) {
            case DENTISTA -> {
                if (authDTO.cro() == null || authDTO.cro().isBlank()) {
                    throw new InvalidCredentialsException("O CRO é obrigatório para o papel de Dentista.");
                }
                yield new UserDTO(authDTO.name(), authDTO.email(), encryptedPassword, authDTO.role(), authDTO.cro(), authDTO.clinicId());
            }
            case ATENDENTE -> {
                if (authDTO.cro() != null) {
                    throw new InvalidCredentialsException("A atendente não pode ter CRO.");
                }
                yield new UserDTO(authDTO.name(), authDTO.email(), encryptedPassword, authDTO.role(), authDTO.clinicId());
            }
            default -> throw new InvalidCredentialsException("Papel de usuário inválido.");
        };

        user = this.userService.insert(user);
        return new RegisterResponseDTO(user.getEmail(), user.getName());
    }

    @Transactional
    public void forgotPassword(String email) {
        User user = userService.findByEmail(email)
                                  .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o e-mail fornecido."));

        // Gera o token JWT específico para redefinição de senha
        String token = tokenService.generatePasswordResetToken(user);

        // Cria o link de redefinição de senha
        String resetUrl = "http://localhost:8080/auth/reset-password?token=" + token;

        // Envia o e-mail
        emailService.sendPasswordResetEmail(user.getEmail(), resetUrl);
    }

    @Transactional
    public void resetPassword(String token, String newPassword, String confirmNewPassword) {
        // Valida as senhas
        validatePassword(newPassword, confirmNewPassword);

        // Valida o token e obtém o e-mail
        String email = tokenService.validatePasswordResetToken(token);
        if (email == null) {
            throw new RuntimeException("Token inválido ou expirado.");
        }

        // Encontra o usuário pelo e-mail
        UserDTO user = new UserDTO(
            userService.findByEmail(email)
                                  .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."))
        );

        // Atualiza a senha
        user.setPassword(passwordEncoder.encode(newPassword));
        userService.updatePassword(user);
    }

    private void validatePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new InvalidCredentialsException("As senhas não coincidem !!");
        }
    }
}
