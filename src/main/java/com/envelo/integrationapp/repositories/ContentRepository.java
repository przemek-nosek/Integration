package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.abstracts.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
}
