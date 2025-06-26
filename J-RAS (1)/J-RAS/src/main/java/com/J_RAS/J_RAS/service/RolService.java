package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.Rol;
import com.J_RAS.J_RAS.model.Usuarios;
import com.J_RAS.J_RAS.repository.RolRepository;
import com.J_RAS.J_RAS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RolService  implements IRolService{
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuarios guardarUsuarioConRol(Usuarios usuario, String nombreRol) {
        Long idRol = usuario.getRol().getId();
        Rol rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombreRol));

        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }
}
