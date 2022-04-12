package com.envelo.integrationapp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
