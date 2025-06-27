package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.RolModel;
import com.J_RAS.J_RAS.model.UsuariosModel;
import com.J_RAS.J_RAS.repository.RolRepository;
import com.J_RAS.J_RAS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RolService  implements IRolService{
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UsuariosModel guardarUsuarioConRol(UsuariosModel usuario, String nombreRol) {
        Long idRol = usuario.getRolModel().getId();
        RolModel rolModel = rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombreRol));

        usuario.setRolModel(rolModel);
        return usuarioRepository.save(usuario);
    }
}
