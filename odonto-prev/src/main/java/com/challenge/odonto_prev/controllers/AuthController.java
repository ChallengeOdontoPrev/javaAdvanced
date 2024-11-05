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
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        List<UserDTO> users =  userService.findByRole(role).stream().map(UserDTO::new).toList();
        users.forEach(user -> {
            user.add(linkTo(methodOn(AuthController.class).register(new RegisterRequestDTO())).withRel("signup"));
            user.add(linkTo(methodOn(AuthController.class).login(new LoginRequestDTO())).withRel("login"));
        });
        return ResponseEntity.ok(users);
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
