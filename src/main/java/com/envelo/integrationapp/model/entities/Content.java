package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.abstracts.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Feedback extends Content {

    public Feedback(String description, User user, int rank) {
        super(description, user);
        this.rank = rank;
    }

    private int rank;
}
