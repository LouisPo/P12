package com.openclassrooms.P12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.P12.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
