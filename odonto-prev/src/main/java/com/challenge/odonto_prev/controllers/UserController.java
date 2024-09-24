package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.UserDTO;
import com.challenge.odonto_prev.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok().body(this.userService.insert(userDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(this.userService.findAll());
    }
}
