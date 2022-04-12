package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.entities.CommentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentAnswerRepository extends JpaRepository<CommentAnswer, Long> {
}
