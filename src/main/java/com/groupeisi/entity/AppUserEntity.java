package com.groupeisi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String firstname;

    @Column(length = 150, nullable = false)
    private String lastname;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name="utilisateurs_roles")
    private List<AppRoleEntity> roles;

    @ManyToOne
    private IaEntity ia;
}
