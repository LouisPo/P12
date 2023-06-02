package com.openclassrooms.P12.repository;

import com.openclassrooms.P12.entities.DicoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DicoUser, Integer> {
	DicoUser findByEmail(String email);
}
