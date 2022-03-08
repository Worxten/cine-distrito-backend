package com.udistrital.cinedistritobackend.api.services.user;

import com.udistrital.cinedistritobackend.api.controllers.payloads.UsuarioClientePayload;
import com.udistrital.cinedistritobackend.api.services.user.entity.UsuarioCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioClienteDTO {
    private long id;
    private String name;
    private String apellido;
    private String nickName;
    private String password;
    private Date fechaNacimiento;
    private int puntos;

    public static UsuarioClienteDTO entityToDto(UsuarioCliente user){

        return new UsuarioClienteDTO(
                user.getId(),
                user.getName(),
                user.getApellido(),
                user.getNickName(),
                user.getPassword(),
                user.getFechaNacimiento(),
                user.getPuntos());
    }

    public static UsuarioClienteDTO payloadToDto(UsuarioClientePayload payload){

        return new UsuarioClienteDTO(
                0,
                payload.getName(),
                payload.getApellido(),
                payload.getNickName(),
                payload.getPassword(),
                payload.getFechaNacimiento(),
                payload.getPuntos());

    }
    
    public static ArrayList<UsuarioClienteDTO> entitiesToDto(ArrayList<UsuarioCliente> clientes){
        ArrayList<UsuarioClienteDTO> clienteDTOS = new ArrayList<>();

        for (UsuarioCliente usuario: clientes) {
            clienteDTOS.add(UsuarioClienteDTO.entityToDto(usuario));
        }
        return clienteDTOS;
    }


}
