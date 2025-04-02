package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.domain.dto.UserDTO;
import com.odontoprev.challenge.domain.dto.auth.LoginRequestDTO;
import com.odontoprev.challenge.domain.dto.auth.LoginResponseDTO;
import com.odontoprev.challenge.domain.dto.auth.RegisterRequestDTO;
import com.odontoprev.challenge.domain.dto.auth.RegisterResponseDTO;
import com.odontoprev.challenge.domain.projection.AuditProjection;
import com.odontoprev.challenge.enums.UserRole;
import com.odontoprev.challenge.services.AuthService;
import com.odontoprev.challenge.services.models.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
                .buildAndExpand(account.getEmail()).toUri();
        return ResponseEntity.created(uri).body(account);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findByRole(@RequestParam UserRole role) {
        List<UserDTO> users = userService.findByRole(role).stream().map(UserDTO::new).toList();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/usersAudit")
    public ResponseEntity<List<AuditProjection>> findAllUserAudits() {
        return ResponseEntity.ok(this.userService.findAllUserAudits());
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
