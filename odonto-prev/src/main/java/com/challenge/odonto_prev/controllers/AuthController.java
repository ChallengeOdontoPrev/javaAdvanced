package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.authDTO.*;
import com.challenge.odonto_prev.services.AuthService;
import com.challenge.odonto_prev.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/forgotPassword")
    public ResponseEntity forgotPassword(@Valid @RequestBody ForgotPasswordResquestDTO data) {
        this.authService.forgotPassword(data.email(), data.newPassword(), data.confirmNewPassword());
        return ResponseEntity.ok().build();
    }

}
