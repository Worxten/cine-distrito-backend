package com.udistrital.cinedistritobackend.api.controllers.user;

import com.udistrital.cinedistritobackend.api.controllers.payloads.UsuarioPayload;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.models.ERole;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.models.Role;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.models.User;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.payloads.JwtTokenResponse;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.payloads.LoginRequest;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.payloads.SignUpRequest;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.repos.RoleRepository;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.repos.UserRepository;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.security.services.MyUserDetailsServiceImpl;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.security.services.UserDetailsImpl;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.security.utils.JwtUtil;
import com.udistrital.cinedistritobackend.api.services.user.usecase.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {


    public final UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UsuarioController (@Qualifier("usuarioService") UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/allclientes")
    public ResponseEntity getClientes(){

        return new ResponseEntity(usuarioService.getClientes(), HttpStatus.OK);
    }

    @GetMapping("/allempleados")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity getEmpleados(){

        return new ResponseEntity(usuarioService.getEmpleados(), HttpStatus.OK);
    }

    @PostMapping("/nuevoUsuario")
    public ResponseEntity createUser(@RequestBody UsuarioPayload payload){
        return new ResponseEntity( (usuarioService.agregarUsuario(payload)),HttpStatus.OK );

    }

    @RequestMapping(value = "/oath" , method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(("Error: Username is already taken!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                "abc@gmail.com",
                encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role user is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role adm is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role mod is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(("User registered successfully!"));
    }

    // Giving the non hard-coded user a token
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtTokenUtil.generateToken(userDetails);

        //UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtTokenResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    // Add 3 types of roles, Cliente = user, admin and empleado
    // UsuarioPayload must have email field
    // Not hard-coded user
    @RequestMapping(value = "/registrar" , method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UsuarioPayload payload) {

        if (userRepository.existsByUsername(payload.getNickName())) {
            return ResponseEntity
                    .badRequest()
                    .body(("Error: Username is already taken!"));
        }

        // Create new user's authentication account

        User user = new User(payload.getNickName(),
                "abc@gmail.com",
                encoder.encode(payload.getPassword()));

        String strRole = payload.getTipo();
        Set<Role> roles = new HashSet<>();

        if (strRole !=null) {
            switch (strRole) {
                case "user":
                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                    break;
                case "admin":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role adm is not found."));
                    roles.add(adminRole);
                    break;
                default:
                case "mod":
                    Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role mod is not found."));
                    roles.add(modRole);
            }
        }
            user.setRoles(roles);
            userRepository.save(user);
        // Creating user of the application
        // Put this in try-catch with the user authentication creation process together
        return new ResponseEntity( (usuarioService.agregarUsuario(payload)),HttpStatus.OK );
        //return ResponseEntity.ok(("User registered successfully!"));
    }
    /*@GetMapping("/all")
    public ResponseEntity getAllUsers(){

        return new ResponseEntity(usuarioService.getAllUsers(), HttpStatus.OK);
    }
    */

}
