package com.udistrital.cinedistritobackend.api.infrastructure.user.repository;

import com.udistrital.cinedistritobackend.api.services.user.entities.Empleado;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("repoEmpleado")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {
}
