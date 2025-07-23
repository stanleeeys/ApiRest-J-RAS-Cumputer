package com.J_RAS.J_RAS.dto;

import lombok.Data;

@Data
public class CarritoRequest {
    private Long usuarioId;
    private Long productoId;
    private Integer cantidad;
}
