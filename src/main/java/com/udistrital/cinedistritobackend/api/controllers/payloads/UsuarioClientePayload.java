package com.udistrital.cinedistritobackend.api.controllers.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.udistrital.cinedistritobackend.api.services.user.UsuarioClienteDTO;
import com.udistrital.cinedistritobackend.api.services.user.entity.UsuarioCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioClientePayload {

    @JsonProperty("nombre")
    private String name;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("alias")
    private String nickName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("fecha")
    private Date fechaNacimiento;
    @JsonProperty("puntos")
    private int puntos;

    public static UsuarioClientePayload dtoToPayload (UsuarioClienteDTO userDTO){
        return new UsuarioClientePayload(
                userDTO.getName(),
                userDTO.getApellido(),
                userDTO.getNickName(),
                userDTO.getPassword(),
                userDTO.getFechaNacimiento(),
                userDTO.getPuntos());
    }

}
