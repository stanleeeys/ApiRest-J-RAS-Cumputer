package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.RolModel;
import com.J_RAS.J_RAS.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.J_RAS.J_RAS.model.Usuarios;
import com.J_RAS.J_RAS.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<Usuarios> ListarUsuario() {
        return this.usuarioRepository.findAll();
    }


    public Usuarios obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);

    }


    public boolean eliminarUsuarioPorId(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }


    public Usuarios guardarUsuario(Usuarios usuario) {
        RolModel rolPorDefecto = rolRepository.findByNombre("CLIENTE");
        usuario.setRol(rolPorDefecto);

        String passEncriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(passEncriptada);

        return usuarioRepository.save(usuario);
    }
}
