package com.J_RAS.J_RAS.dto;

import com.J_RAS.J_RAS.model.CategoriaModel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String imagen_url;
    private CategoriaModel categorias;
}
