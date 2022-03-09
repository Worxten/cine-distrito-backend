package com.udistrital.cinedistritobackend.api.services.user.entities;

import com.udistrital.cinedistritobackend.api.services.user.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario{

    @Column
    private int puntos;

    public Cliente(Long id, String name, String apellido, String nickName, String password, Date fechaNacimiento, String tipo, int puntos) {
        super(id, name, apellido, nickName, password, fechaNacimiento, tipo);
        this.puntos = puntos;
    }

    public static Cliente dtoToEntity(UsuarioDTO userDTO){
        return new Cliente(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getApellido(),
                userDTO.getNickName(),
                userDTO.getPassword(),
                userDTO.getFechaNacimiento(),
                userDTO.getTipo(),
                userDTO.getPuntos());
    }
}
