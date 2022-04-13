package com.envelo.integrationapp.services;

import com.envelo.integrationapp.model.dtos.PostCommentDto;
import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Post;
import com.envelo.integrationapp.model.entities.PostComment;
import com.envelo.integrationapp.repositories.PostCommentRepository;
import com.envelo.integrationapp.repositories.PostRepository;
import com.envelo.integrationapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostCommentService {

    private final PostCommentRepository postCommentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void updateComment(Long id, PostCommentDto postCommentDto) {
        PostComment postComment = postCommentRepository.getById(id);

        postComment.setDescription(postCommentDto.getDescription());
    }

    @Transactional
    public void addCommentPost(long postId, long userId, String description) {
        AppUser appUser = userRepository.getById(userId);
        Post post = postRepository.getById(postId);
        PostComment postComment = new PostComment();
        post.getPostComments().add(postComment);
        postComment.setDescription(description);
        postComment.setAppUser(appUser);
        postCommentRepository.save(postComment);
    }
}
