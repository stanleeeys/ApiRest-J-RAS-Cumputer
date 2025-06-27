package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.UsuariosModel;

public interface IRolService {
    UsuariosModel guardarUsuarioConRol(UsuariosModel usuario, String nombreRol);
}
