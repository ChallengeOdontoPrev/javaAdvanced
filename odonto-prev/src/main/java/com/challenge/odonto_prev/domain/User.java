package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column(unique = true)
    private String cro;
    private LocalDateTime createdAt;

    @ManyToOne
    private Clinica clinica;

    // Dentista
    public User(String name, String email, String password, String cro, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cro = cro;
        this.role = role;
    }

    // Atendente
    public User(String name, String email, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_ATENDENTE"),
                    new SimpleGrantedAuthority("ROLE_DENTISTA")
            );
        } else if (role == UserRole.DENTISTA) {
            return List.of(new SimpleGrantedAuthority("ROLE_DENTISTA"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_ATENDENTE"));
        }
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
