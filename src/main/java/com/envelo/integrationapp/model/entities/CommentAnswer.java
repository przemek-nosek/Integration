package com.envelo.integrationapp.model.entities;


import com.envelo.integrationapp.model.abstracts.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comment_answers")
@NoArgsConstructor
@Getter
@Setter
public class CommentAnswer extends Content {
}
