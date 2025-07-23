package com.J_RAS.J_RAS.dto;

import com.J_RAS.J_RAS.model.RolModel;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private RolModel rol;
}

