package com.udistrital.cinedistritobackend.api.controllers.user;

import com.udistrital.cinedistritobackend.api.controllers.payloads.UsuarioClientePayload;
import com.udistrital.cinedistritobackend.api.services.user.usecase.UsuarioService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    public final UsuarioService usuarioService;

    public UsuarioController (@Qualifier("usa") UsuarioService usuarioService) {
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
