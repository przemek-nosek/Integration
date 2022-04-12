package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.abstracts.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "feedbacks")
@NoArgsConstructor
@Getter
@Setter
public class Feedback extends Content {
    private int rating;
}
