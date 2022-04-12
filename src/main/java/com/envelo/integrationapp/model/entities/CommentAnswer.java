package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.abstracts.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CommentAnswer extends Content {
}
