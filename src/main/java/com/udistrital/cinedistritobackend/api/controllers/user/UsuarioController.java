package com.udistrital.cinedistritobackend.api.controllers.user;

import com.udistrital.cinedistritobackend.api.controllers.payloads.UsuarioClientePayload;
import com.udistrital.cinedistritobackend.api.services.user.usecase.RegistrarUsuarioUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final RegistrarUsuarioUseCase usuarioService;

    public UsuarioController (RegistrarUsuarioUseCase usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity(usuarioService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/nuevoUsuario")
    public ResponseEntity createUser(@RequestBody UsuarioClientePayload payload){
        return new ResponseEntity( (usuarioService.agregarUsuario(payload)),HttpStatus.OK );

    }

}
