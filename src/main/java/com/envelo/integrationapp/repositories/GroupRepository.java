package com.envelo.integrationapp.repositories;

import com.envelo.integrationapp.model.entities.User_Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<User_Group, Long> {
}
