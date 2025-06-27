package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.ProductosModel;

import java.util.List;

public interface IProductoService  {
    public List<ProductosModel> listarProductos();

    public ProductosModel buscarProductoPorId(Long idProducto);

    public ProductosModel guardarProducto(ProductosModel producto);

    void eliminarProductoPorId(Long idProducto);

    public List<ProductosModel> buscarProductosPorNombre(String nombre);

    public ProductosModel actualizarProductos (Long idProducto, ProductosModel nuevoProducto);

}
