package com.odontoprev.challenge.domain;

import com.odontoprev.challenge.domain.dto.UserDTO;
import com.odontoprev.challenge.enums.UserRole;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User extends People implements UserDetails {

    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(unique = true)
    private String cro;

    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    public User() {
    }

    public User(String email, String password, UserRole role, String cro, List<Appointment> appointments, Clinic clinic) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.cro = cro;
        this.appointments = appointments;
        this.clinic = clinic;
    }

    // Dentista
    public User(String name, String rg, LocalDate birthDate, String email, String password, String cro, UserRole role) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.cro = cro;
        this.role = role;
        this.setRg(rg);
        this.setBirthDate(birthDate);
    }

    // Atendente
    public User(String name, String rg, LocalDate birthDate, String email, String password, UserRole role) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.role = role;
        this.setRg(rg);
        this.setBirthDate(birthDate);
    }

    public User(UserDTO userDTO) {
        this.setId(userDTO.getId());
        this.setName(userDTO.getName());
        this.setBirthDate(userDTO.getBirthDate());
        this.setRg(userDTO.getRg());
        this.setEmail(userDTO.getEmail());
        this.setPassword(userDTO.getPassword());
        this.role = userDTO.getRole();
        this.cro = userDTO.getCro();
        this.setCreatedAt(LocalDate.now());
    }

    public User(User user) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setRg(user.getRg());
        this.setBirthDate(user.getBirthDate());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.role = user.getRole();
        this.cro = user.getCro();
        this.setCreatedAt(user.getCreatedAt());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
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
