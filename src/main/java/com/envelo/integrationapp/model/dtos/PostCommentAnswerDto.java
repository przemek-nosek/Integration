package com.envelo.integrationapp.model.dtos;

import com.envelo.integrationapp.model.entities.CommentAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostCommentAnswerDto {
    private Long commentId;
    private String description;
}