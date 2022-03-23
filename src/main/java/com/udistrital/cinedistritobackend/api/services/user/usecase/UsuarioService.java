package com.udistrital.cinedistritobackend.api.services.user.usecase;

import com.udistrital.cinedistritobackend.api.controllers.payloads.UsuarioPayload;
import com.udistrital.cinedistritobackend.api.infrastructure.user.repository.IClienteRepository;
import com.udistrital.cinedistritobackend.api.infrastructure.user.repository.IEmpleadoRepository;
import com.udistrital.cinedistritobackend.api.infrastructure.user.repository.IUsuarioRepository;
import com.udistrital.cinedistritobackend.api.services.user.dto.UsuarioDTO;
import com.udistrital.cinedistritobackend.api.services.user.entities.Cliente;
import com.udistrital.cinedistritobackend.api.services.user.entities.Empleado;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Qualifier("usuarioService")
public class UsuarioService {

//private IUsuarioRepository repository;
private IClienteRepository clienteRepository;
private IEmpleadoRepository empleadoRepository;

public UsuarioService(@Qualifier("repoCliente") IClienteRepository clienteRepository,
                      @Qualifier("repoEmpleado") IEmpleadoRepository empleadoRepository){

    //this.repository = repository;
    this.clienteRepository = clienteRepository;
    this.empleadoRepository = empleadoRepository;
}

public UsuarioDTO agregarUsuario(UsuarioPayload payload){
    UsuarioDTO userDTO= UsuarioDTO.payloadToDto(payload);

    // equals Cliente = user
    if(userDTO.getTipo().equals("user")){
        //UsuarioCliente user = UsuarioCliente.dtoToEntity(userDTO);
        userDTO.setTipo("Cliente");
        Cliente cliente = Cliente.dtoToEntity(userDTO);
        clienteRepository.save(cliente);

        //repository.save(user);
    }else{
        Empleado empleado = Empleado.dtoToEntity(userDTO);
        empleadoRepository.save(empleado);
        //repository.save(empleado);
    }

    return userDTO;
}

public ArrayList<UsuarioDTO> getClientes(){
    ArrayList<Cliente> usuariosClientes = (ArrayList<Cliente>) clienteRepository.findAll();
    ArrayList<UsuarioDTO> clienteDTOS = UsuarioDTO.clientesToDto(usuariosClientes);
    return clienteDTOS;
}

    public ArrayList<UsuarioDTO> getEmpleados(){
        ArrayList<Empleado> usuarioEmpleados = (ArrayList<Empleado>) empleadoRepository.findAll();
        ArrayList<UsuarioDTO>  empleadoDTOS = UsuarioDTO.empleadosToDto(usuarioEmpleados);
        return empleadoDTOS;
    }



/*public ArrayList<UsuarioDTO> getAllUsers(){
    ArrayList<UsuarioCliente> usuariosClientes = (ArrayList<UsuarioCliente>) repository.findAll();
    ArrayList<UsuarioDTO> clienteDTOS = UsuarioDTO.entitiesToDto(usuariosClientes);
    return clienteDTOS;
}*/
}
