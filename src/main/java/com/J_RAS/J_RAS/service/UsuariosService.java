package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.RolModel;
import com.J_RAS.J_RAS.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.J_RAS.J_RAS.model.UsuariosModel;
import com.J_RAS.J_RAS.repository.UsuarioRepository;
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


    public List<UsuariosModel> ListarUsuario() {
        return this.usuarioRepository.findAll();
    }


    public UsuariosModel buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);

    }


    public void eliminarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }


    public UsuariosModel guardarUsuario(UsuariosModel usuario) {
        RolModel rolPorDefecto = rolRepository.findByNombre("CLIENTE");
        usuario.setRol(rolPorDefecto);

        String passEncriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(passEncriptada);

        return usuarioRepository.save(usuario);
    }
}
