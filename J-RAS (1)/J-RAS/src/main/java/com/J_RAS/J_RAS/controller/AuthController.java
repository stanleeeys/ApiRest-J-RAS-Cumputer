package com.J_RAS.J_RAS.controller;

import com.J_RAS.J_RAS.dto.LoginRequest;
import com.J_RAS.J_RAS.model.Usuarios;
import com.J_RAS.J_RAS.repository.UsuarioRepository;
import com.J_RAS.J_RAS.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil security;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // 1. Buscar el usuario por email
        Optional<Usuarios> optionalUsuario = usuarioRepository.findByEmail(request.getEmail());

        if (optionalUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }

        Usuarios usuario = optionalUsuario.get();

        // 2. Verificar la contraseña
        if (!passwordEncoder.matches(request.getContrasena(), usuario.getContrasena())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        // 3. Generar el token
        String token = security.generarToken(usuario.getEmail());

        // 4. Devolver el token y datos del usuario
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("usuario", usuario.getNombre());
        // response.put("rol", usuario.getRol());

        return ResponseEntity.ok(response);
    }

}
