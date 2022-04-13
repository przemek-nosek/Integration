package com.envelo.integrationapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostCommentDto {
    private Long id;
    private String description;
    private Long userId;
}
