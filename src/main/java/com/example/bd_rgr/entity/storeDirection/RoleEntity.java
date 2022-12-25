package com.example.bd_rgr.entity.storeDirection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "roles")
@Setter
@Getter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<UserEntity> users;

    @Override
    public String toString() {
        return "Role{" +
                "id: " + getId() + ", " +
                "name: " + name + "}";
    }
}