package com.udistrital.cinedistritobackend.api.controllers.user;

import com.udistrital.cinedistritobackend.api.controllers.payloads.UsuarioPayload;
import com.udistrital.cinedistritobackend.api.services.user.usecase.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {


    public final UsuarioService usuarioService;

    public UsuarioController (@Qualifier("usuarioService") UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/allclientes")
    public ResponseEntity getClientes(){

        return new ResponseEntity(usuarioService.getClientes(), HttpStatus.OK);
    }
    @GetMapping("/allempleados")
    public ResponseEntity getEmpleados(){

        return new ResponseEntity(usuarioService.getEmpleados(), HttpStatus.OK);
    }

    @PostMapping("/nuevoUsuario")
    public ResponseEntity createUser(@RequestBody UsuarioPayload payload){
        return new ResponseEntity( (usuarioService.agregarUsuario(payload)),HttpStatus.OK );

    }



    /*@GetMapping("/all")
    public ResponseEntity getAllUsers(){

        return new ResponseEntity(usuarioService.getAllUsers(), HttpStatus.OK);
    }
    */

}
