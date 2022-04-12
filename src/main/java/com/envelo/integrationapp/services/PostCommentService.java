package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.PostCommentDto;
import com.envelo.integrationapp.model.entities.PostComment;
import com.envelo.integrationapp.repositories.PostCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostCommentService {

    private final PostCommentRepository postCommentRepository;

    @Transactional
    public void updateComment(Long id, PostCommentDto postCommentDto) {
        PostComment postComment = postCommentRepository.getById(id);

        postComment.setDescription(postCommentDto.getDescription());
    }
}
