package com.envelo.integrationapp.model.dtos;

import com.envelo.integrationapp.model.entities.PostComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostEditionDto {
    private Long postId;
    private byte[] file;
    private String description;
}
