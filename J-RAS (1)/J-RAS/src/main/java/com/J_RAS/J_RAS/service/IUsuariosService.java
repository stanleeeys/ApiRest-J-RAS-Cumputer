package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.Usuarios;

import java.util.List;

public interface IUsuariosService {
     List<Usuarios>ListarUsuario();

     Usuarios buscarUsuario(Long id);

    Usuarios guardarUsuario(Usuarios usuarios);

     void eliminarUsuarioPorId(Long id);
}
