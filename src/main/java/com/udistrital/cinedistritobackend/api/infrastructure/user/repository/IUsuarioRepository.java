package com.udistrital.cinedistritobackend.api.infrastructure.user.repository;

import com.udistrital.cinedistritobackend.api.services.user.entity.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioCliente, Long>
{
    UsuarioCliente nuevoUsuario(UsuarioCliente user);
}
