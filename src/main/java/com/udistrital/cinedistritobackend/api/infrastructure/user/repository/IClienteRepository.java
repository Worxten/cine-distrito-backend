package com.udistrital.cinedistritobackend.api.infrastructure.user.repository;

import com.udistrital.cinedistritobackend.api.services.user.entities.Cliente;
import com.udistrital.cinedistritobackend.api.services.user.entities.UsuarioCliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("repoCliente")
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
