package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.Clinic;
import com.challenge.odonto_prev.domain.User;
import com.challenge.odonto_prev.domain.dto.UserDTO;
import com.challenge.odonto_prev.enums.UserRole;
import com.challenge.odonto_prev.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClinicService clinicService;

    @Transactional
    public UserDTO insert(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setClinic(new Clinic(
                this.clinicService.findById(userDTO.getClinicId())
        ));
        user.setCreatedAt(LocalDate.now());
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO updatePassword(UserDTO userDTO) {
        User user = this.userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Conta não encontrada"));

        user.setPassword(userDTO.getPassword());
        return new UserDTO(this.userRepository.save(user));
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Conta não encontrada"));
    }

    public Optional<User> loadUserByUsername(String email) {
        return this.userRepository.findByEmail(email);
    }

    public List<UserDTO> findAll() {
        return this.userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    public User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    public User findByRole(UserRole role) {
        return this.userRepository.findByRole(role)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }


}
