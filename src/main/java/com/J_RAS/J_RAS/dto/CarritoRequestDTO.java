package com.J_RAS.J_RAS.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarritoRequestDTO {
    private Long id;
    private Integer cantidad;
    private LocalDateTime fecha_agregado;
    private UsuarioDTO usuario;
    private ProductoDTO producto;

}
