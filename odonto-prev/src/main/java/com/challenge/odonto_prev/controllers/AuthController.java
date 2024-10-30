package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.UserDTO;
import com.challenge.odonto_prev.domain.dto.authDTO.LoginRequestDTO;
import com.challenge.odonto_prev.domain.dto.authDTO.LoginResponseDTO;
import com.challenge.odonto_prev.domain.dto.authDTO.RegisterRequestDTO;
import com.challenge.odonto_prev.domain.dto.authDTO.RegisterResponseDTO;
import com.challenge.odonto_prev.enums.UserRole;
import com.challenge.odonto_prev.services.AuthService;
import com.challenge.odonto_prev.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO data) {
        return ResponseEntity.ok(this.authService.login(data));
    }

    @PostMapping("/signup")
    public ResponseEntity<RegisterResponseDTO> register(@Valid @RequestBody RegisterRequestDTO data) {
        RegisterResponseDTO account = this.authService.signup(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
                .buildAndExpand(account.email()).toUri();
        return ResponseEntity.created(uri).body(account);
    }

    @GetMapping
    public ResponseEntity<UserDTO> findByRole(@RequestParam UserRole role) {
        return ResponseEntity.ok(new UserDTO(userService.findByRole(role)));
    }

    // Endpoint para solicitar a redefinição de senha
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam("email") String email) {
        authService.forgotPassword(email);
        return ResponseEntity.ok("E-mail de redefinição de senha enviado.");
    }

    // Endpoint para redefinir a senha
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token,
                                                @RequestParam("newPassword") String newPassword,
                                                @RequestParam("confirmNewPassword") String confirmNewPassword) {
        authService.resetPassword(token, newPassword, confirmNewPassword);
        return ResponseEntity.ok("Senha redefinida com sucesso.");
    }

}
