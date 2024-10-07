package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.domain.dto.UserDTO;
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

    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

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

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.role = userDTO.getRole();
        this.cro = userDTO.getCro();
        this.createdAt = LocalDateTime.now();
    }

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.cro = user.getCro();
        this.createdAt = user.getCreatedAt();
        this.clinic = user.getClinic();
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
