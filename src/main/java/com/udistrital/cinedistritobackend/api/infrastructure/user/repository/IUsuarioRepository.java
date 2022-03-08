package com.udistrital.cinedistritobackend.api.infrastructure.user.repository;

import com.udistrital.cinedistritobackend.api.services.user.entity.UsuarioCliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("repo")
public interface IUsuarioRepository extends JpaRepository<UsuarioCliente, Long>
{
    UsuarioCliente nuevoUsuario(UsuarioCliente user);
}
