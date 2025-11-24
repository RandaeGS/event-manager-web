package com.randaegs.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
@Audited
public class User extends PanacheEntity {

    @NotBlank(message = "First name cannot be blank")
    @NotNull(message = "First name cannot be empty")
    public String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @NotNull(message = "Last name cannot be empty")
    public String lastName;

    @Column(unique = true)
    public String email;

    @Length(min = 8, message = "Password is too short", max = 20)
    @NotNull(message = "Password cant be empty")
    public String password;

    @NotNull(message = "User must have a role")
    @ManyToOne
    @JoinColumn(name = "user_role")
    @JsonManagedReference
    public Role role;

    public String organization;

    public User() {
    }
}
