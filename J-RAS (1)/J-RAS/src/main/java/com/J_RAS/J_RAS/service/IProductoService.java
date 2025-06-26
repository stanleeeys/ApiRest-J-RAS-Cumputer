package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.Productos;

import java.util.List;

public interface IProductoService  {
    public List<Productos> listarProductos();

    public Productos buscarProductoPorId(Long idProducto);

    public Productos guardarProducto(Productos producto);

    void eliminarProductoPorId(Long idProducto);

    public List<Productos> buscarProductosPorNombre(String nombre);

    public Productos actualizarProductos (Long idProducto, Productos productoActualizado);

}
