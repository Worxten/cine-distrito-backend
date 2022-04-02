package com.udistrital.cinedistritobackend.api.services.user.entities;

import com.udistrital.cinedistritobackend.api.services.user.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String apellido;
    @Column
    private String nickName;
    @Column
    private String password;
    @Column
    private Date fechaNacimiento;
    @Column
    private int puntos;

    public static UsuarioCliente dtoToEntity(UsuarioDTO userDTO){
        return new UsuarioCliente(
            userDTO.getId(),
            userDTO.getName(),
            userDTO.getApellido(),
                userDTO.getNickName(),
            userDTO.getPassword(),
            userDTO.getFechaNacimiento(),
            userDTO.getPuntos());
    }
}
