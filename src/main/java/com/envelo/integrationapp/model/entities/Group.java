package com.envelo.integrationapp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_entity")
@NoArgsConstructor
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private List<AppUser> users;
}
