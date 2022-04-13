package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.CommentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentAnswerRepository extends JpaRepository<CommentAnswer, Long> {

    Optional<CommentAnswer> findByIdAndAppUser(Long id, AppUser appUser);
}
