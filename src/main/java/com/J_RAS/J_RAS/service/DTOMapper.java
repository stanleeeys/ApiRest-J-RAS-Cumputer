package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.dto.CarritoRequestDTO;
import com.J_RAS.J_RAS.dto.ProductoDTO;
import com.J_RAS.J_RAS.dto.UsuarioDTO;
import com.J_RAS.J_RAS.model.CarritoModel;
import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.model.Usuarios;

public class DTOMapper {
    public static UsuarioDTO toUsuarioDTO(Usuarios usuario) {
        if (usuario == null) return null;

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        return dto;
    }

    public static ProductoDTO toProductoDTO(ProductosModel producto) {
        if (producto == null) return null;

        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setImagen_url(producto.getImagen_url());
        dto.setCategorias(producto.getCategorias());
        return dto;
    }

    public static CarritoRequestDTO toCarritoDTO(CarritoModel carrito) {
        if (carrito == null) return null;

        CarritoRequestDTO dto = new CarritoRequestDTO();
        dto.setId(carrito.getId());
        dto.setCantidad(carrito.getCantidad());
        dto.setFecha_agregado(carrito.getFecha_agregado());
        dto.setUsuario(toUsuarioDTO(carrito.getUsuario()));
        dto.setProducto(toProductoDTO(carrito.getProducto()));
        return dto;
    }
}
