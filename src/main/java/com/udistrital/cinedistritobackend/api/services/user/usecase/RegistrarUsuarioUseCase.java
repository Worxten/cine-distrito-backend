package com.udistrital.cinedistritobackend.api.services.user.usecase;

import com.udistrital.cinedistritobackend.api.controllers.payloads.UsuarioClientePayload;
import com.udistrital.cinedistritobackend.api.infrastructure.user.repository.IUsuarioRepository;
import com.udistrital.cinedistritobackend.api.services.user.UsuarioClienteDTO;
import com.udistrital.cinedistritobackend.api.services.user.entity.UsuarioCliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegistrarUsuarioUseCase {

private final IUsuarioRepository repository;

public RegistrarUsuarioUseCase (IUsuarioRepository repository){
    this.repository = repository;
}

public UsuarioClienteDTO agregarUsuario(UsuarioClientePayload payload){
    UsuarioClienteDTO userDTO= UsuarioClienteDTO.payloadToDto(payload);
    UsuarioCliente user = UsuarioCliente.dtoToEntity(userDTO);
    repository.save(user);
    return userDTO;
}

public ArrayList<UsuarioClienteDTO> getAllUsers(){
    ArrayList<UsuarioCliente> usuariosClientes = (ArrayList<UsuarioCliente>) repository.findAll();
    ArrayList<UsuarioClienteDTO> clienteDTOS = UsuarioClienteDTO.entitiesToDto(usuariosClientes);
    return clienteDTOS;
}
}
