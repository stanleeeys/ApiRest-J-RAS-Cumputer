package com.J_RAS.J_RAS.controller;

import com.J_RAS.J_RAS.model.Usuarios;
import com.J_RAS.J_RAS.service.IUsuariosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private IUsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> obtenerUsuarios(){
        List<Usuarios> usuarios = this.usuariosService.ListarUsuario();
        logger.info("Usuario obtenido");
        usuarios.forEach(usuario -> logger.info(usuario.toString()));
        return usuarios;
    }
    @PostMapping
    public ResponseEntity<Usuarios> agregarUsuarios(@RequestBody Usuarios usuarios) {
        logger.info("Usuarios a agregar: {}", usuarios);
        Usuarios usuarioGuardado = this.usuariosService.guardarUsuario(usuarios);
        return ResponseEntity.ok(usuarioGuardado);

    }
}
