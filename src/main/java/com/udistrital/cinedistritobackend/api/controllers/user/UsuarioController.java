package com.udistrital.cinedistritobackend.api.controllers.user;

import com.udistrital.cinedistritobackend.api.services.user.usecase.RegistrarUsuarioUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final RegistrarUsuarioUseCase usuarioService;

    public UsuarioController (RegistrarUsuarioUseCase usuarioService) {
        this.usuarioService = usuarioService;
    }



}
