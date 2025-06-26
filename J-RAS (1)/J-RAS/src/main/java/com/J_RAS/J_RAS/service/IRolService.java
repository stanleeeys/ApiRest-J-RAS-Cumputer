package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.Rol;
import com.J_RAS.J_RAS.model.Usuarios;

import java.util.List;

public interface IRolService {
    Usuarios guardarUsuarioConRol(Usuarios usuario, String nombreRol);
}
