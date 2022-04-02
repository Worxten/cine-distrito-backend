package com.udistrital.cinedistritobackend.api.services.user.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuario {

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
    private String tipo;

}
