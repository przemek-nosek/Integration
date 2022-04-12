package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.abstracts.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "post_comments")
@NoArgsConstructor
@Getter
@Setter
public class PostComment extends Content {
    @OneToMany
    @JoinColumn(name = "post_comment_id")
    private List<CommentAnswer> commentAnswers = new ArrayList<>();
}
