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
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado extends Usuario{

    @Column
    private String cargo;


        public Empleado(Long id, String name, String apellido, String nickName, String password, Date fechaNacimiento, String tipo,
                        String cargo) {
        super(id, name, apellido, nickName, password, fechaNacimiento, tipo);
this.cargo = cargo;
    }

    public static Empleado dtoToEntity(UsuarioDTO userDTO){
        return new Empleado(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getApellido(),
                userDTO.getNickName(),
                userDTO.getPassword(),
                userDTO.getFechaNacimiento(),
                userDTO.getTipo(),
                userDTO.getCargo());
    }
}
