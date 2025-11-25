package com.randaegs.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = "roles")
@Audited
public class UserRole extends PanacheEntity {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    @Column(unique = true)
    public String name;

    @OneToMany(mappedBy = "userRole")
    @JsonIgnore
    public List<User> users;

    public UserRole() {
    }

    public static UserRole findByName(String name){
        return find("upper(name)", name.toUpperCase()).firstResult();
    }
}
