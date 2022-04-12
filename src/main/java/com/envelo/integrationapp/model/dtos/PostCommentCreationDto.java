package com.envelo.integrationapp.model.dtos;

import com.envelo.integrationapp.model.entities.CommentAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostCommentCreationDto {
    private Long postId;
    private String description;
}
