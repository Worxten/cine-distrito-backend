package com.udistrital.cinedistritobackend.api.controllers.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.udistrital.cinedistritobackend.api.services.user.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPayload {

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
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("cargo")
    private String cargo;

    public static UsuarioPayload dtoToPayload (UsuarioDTO userDTO){
        return new UsuarioPayload(
                userDTO.getName(),
                userDTO.getApellido(),
                userDTO.getNickName(),
                userDTO.getPassword(),
                userDTO.getFechaNacimiento(),
                userDTO.getPuntos(),
                userDTO.getTipo(),
        userDTO.getCargo());
    }

}
