package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.Clinica;
import com.challenge.odonto_prev.domain.User;
import com.challenge.odonto_prev.domain.dto.UserDTO;
import com.challenge.odonto_prev.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClinicaService clinicaService;

    @Transactional
    public UserDTO insert(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setCreatedAt(LocalDateTime.now());
        user.setClinica(new Clinica(this.clinicaService.findById(userDTO.getClinicaId())));
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User loadUserByUsername(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Conta não encontrada"));
    }

    public List<UserDTO> findAll() {
        return this.userRepository.findAll().stream().map(UserDTO::new).toList();
    }
}
