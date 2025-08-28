package com.J_RAS.J_RAS.controller;

import com.J_RAS.J_RAS.model.Usuarios;
import com.J_RAS.J_RAS.service.UsuariosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable Long id){
        Usuarios usuario = usuariosService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(path = "/{id}")
        public String eliminarProductoPorId(@PathVariable("id")Long id){
            boolean ok = this.usuariosService.eliminarUsuarioPorId(id);
            if (ok){
                return "Se elimino el usuario con id " + id;
            }else {
                return "no se pudo eliminar el usuario con id" + id;
            }
        }

}
