package com.udistrital.cinedistritobackend.api.infrastructure.authentication.repos;

import com.udistrital.cinedistritobackend.api.infrastructure.authentication.models.ERole;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

