package com.randaegs.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
@Audited
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "First name cannot be blank")
    @NotNull(message = "First name cannot be empty")
    @Column(name = "first_name")
    public String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @NotNull(message = "Last name cannot be empty")
    @Column(name = "last_name")
    public String lastName;

    @Column(unique = true)
    public String email;

    @Length(min = 8, message = "Password is too short")
    @NotNull(message = "Password cant be empty")
    public String password;

    @ManyToOne
    @JoinColumn(name = "user_role")
    public UserRole userRole;

    @Transient
    public String role;

    public String organization;

    public User() {
    }
}
