package com.envelo.integrationapp.model.dtos;

import com.envelo.integrationapp.model.entities.PostComment;
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
public class PostCreationDto {
    private Long eventId;
    private byte[] file;
    private String description;
    private List<PostComment> postComments = new ArrayList<>();
}
