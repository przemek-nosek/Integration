package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Event;
import com.envelo.integrationapp.model.enums.EventRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);
}
