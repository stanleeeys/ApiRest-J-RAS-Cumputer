package com.J_RAS.J_RAS.controller;

import com.J_RAS.J_RAS.model.UsuariosModel;
import com.J_RAS.J_RAS.service.UsuariosService;
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
    private UsuariosService usuariosService;

    @GetMapping
    public List<UsuariosModel> obtenerUsuarios(){
        List<UsuariosModel> usuarios = this.usuariosService.ListarUsuario();
        logger.info("Usuario obtenido");
        usuarios.forEach(usuario -> logger.info(usuario.toString()));
        return usuarios;
    }
    @PostMapping
    public ResponseEntity<UsuariosModel> agregarUsuarios(@RequestBody UsuariosModel usuariosModel) {
        logger.info("Usuarios a agregar: {}", usuariosModel);
        UsuariosModel usuarioGuardado = this.usuariosService.guardarUsuario(usuariosModel);
        return ResponseEntity.ok(usuarioGuardado);

    }
}
