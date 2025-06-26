package com.J_RAS.J_RAS.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.J_RAS.J_RAS.model.Usuarios;
import com.J_RAS.J_RAS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService implements IUsuariosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuarios> ListarUsuario() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuarios buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);

    }

    @Override
    public void eliminarUsuarioPorId(Long id) {
       usuarioRepository.deleteById(id);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario) {
        // Encriptar la contraseña antes de guardar
        String passEncriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(passEncriptada);

        // Guardar usuario en BD
        return usuarioRepository.save(usuario);
    }
}
