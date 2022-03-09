package com.udistrital.cinedistritobackend.api.services.user.dto;

import com.udistrital.cinedistritobackend.api.controllers.payloads.UsuarioPayload;
import com.udistrital.cinedistritobackend.api.services.user.entities.Cliente;
import com.udistrital.cinedistritobackend.api.services.user.entities.Empleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
// Esta clase contiene todas las propiedades (Cliente y Empleado)
public class UsuarioDTO {

    private long id;
    private String name;
    private String apellido;
    private String nickName;
    private String password;
    private Date fechaNacimiento;
    private int puntos;
    private String tipo;
    private String cargo;

    public static UsuarioDTO entityToDtoCliente(Cliente user){

        return new UsuarioDTO(
                user.getId(),
                user.getName(),
                user.getApellido(),
                user.getNickName(),
                user.getPassword(),
                user.getFechaNacimiento(),
                user.getPuntos(),
                user.getTipo(),
                null
        );
    }

    public static UsuarioDTO entityToDtoEmpleado(Empleado user){

        return new UsuarioDTO(
                user.getId(),
                user.getName(),
                user.getApellido(),
                user.getNickName(),
                user.getPassword(),
                user.getFechaNacimiento(),
                0,
                null,
                null
        );
    }

    public static UsuarioDTO payloadToDto(UsuarioPayload payload){

        return new UsuarioDTO(
                0,
                payload.getName(),
                payload.getApellido(),
                payload.getNickName(),
                payload.getPassword(),
                payload.getFechaNacimiento(),
                payload.getPuntos(),
                payload.getTipo(),
                payload.getCargo());

    }

    public static ArrayList<UsuarioDTO> clientesToDto(ArrayList<Cliente> clientes){
        ArrayList<UsuarioDTO> clienteDTOS = new ArrayList<>();

        for (Cliente usuario: clientes) {
            clienteDTOS.add(UsuarioDTO.entityToDtoCliente(usuario));
        }
        return clienteDTOS;
    }

    public static ArrayList<UsuarioDTO> empleadosToDto(ArrayList<Empleado> empleados){
        ArrayList<UsuarioDTO> empleadoDTOS = new ArrayList<>();

        for (Empleado usuario: empleados) {
            empleadoDTOS.add(UsuarioDTO.entityToDtoEmpleado(usuario));
        }
        return empleadoDTOS;
    }


    /*public static UsuarioDTO entityToDtoCliente(UsuarioCliente user){

        return new UsuarioDTO(
                user.getId(),
                user.getName(),
                user.getApellido(),
                user.getNickName(),
                user.getPassword(),
                user.getFechaNacimiento(),
                user.getPuntos(),
                null,
                null
        );
    }*/

    /*public static ArrayList<UsuarioDTO> entitiesToDto(ArrayList<UsuarioCliente> clientes){
        ArrayList<UsuarioDTO> clienteDTOS = new ArrayList<>();

        /*for (UsuarioCliente usuario: clientes) {
            clienteDTOS.add(UsuarioDTO.entityToDto(usuario));
        }
        return clienteDTOS;
    }*/

}
