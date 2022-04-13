package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.enums.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_groups", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "groups_id"))
    private Set<Group> groups = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
}
