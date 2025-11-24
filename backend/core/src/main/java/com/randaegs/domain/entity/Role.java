package com.randaegs.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = "roles")
@Audited
public class Role extends PanacheEntity {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    @Column(unique = true)
    public String name;

    @OneToMany
    @JsonBackReference
    public List<User> users;

    public Role() {
    }
}
