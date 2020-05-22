package com.waterkemper.springsecurityjwt.repositories;

import com.waterkemper.springsecurityjwt.model.Role;
import com.waterkemper.springsecurityjwt.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}