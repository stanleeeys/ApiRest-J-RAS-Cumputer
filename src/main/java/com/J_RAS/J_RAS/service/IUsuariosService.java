package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.UsuariosModel;

import java.util.List;

public interface IUsuariosService {
     List<UsuariosModel>ListarUsuario();

     UsuariosModel buscarUsuario(Long id);

    UsuariosModel guardarUsuario(UsuariosModel usuariosModel);

     void eliminarUsuarioPorId(Long id);
}
