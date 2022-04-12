package com.envelo.integrationapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private LocalDateTime date;
    private List<PostCommentDto> postComments = new ArrayList<>();
    private long appUserId;
}
