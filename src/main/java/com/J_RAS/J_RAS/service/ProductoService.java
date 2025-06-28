package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public List<ProductosModel> listarProductos() {
        return this.productoRepository.findAll();
    }

    public ProductosModel buscarProductoPorId(Long id) {
        ProductosModel productosModel = this.productoRepository.findById(id).orElse(null);
        return productosModel;
    }

    public ProductosModel guardarProducto(ProductosModel productosModel) {

        return productoRepository.save(productosModel);

    }

    public boolean eliminarProductoPorId(Long id) {
       try {
           productoRepository.deleteById(id);
           return true;
       }catch (Exception err){
           return false;
       }
    }


    public List<ProductosModel> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }


    public ProductosModel actualizarProductos(Long id, ProductosModel nuevoProducto) {
        try {
            ProductosModel existeProducto = productoRepository.findById(id).orElse(null);
            if (existeProducto != null) {
                existeProducto.setNombre(nuevoProducto.getNombre());
                existeProducto.setDescripcion(nuevoProducto.getDescripcion());
                existeProducto.setPrecio(nuevoProducto.getPrecio());
                existeProducto.setCategorias(nuevoProducto.getCategorias());
                existeProducto.setImagen_url(nuevoProducto.getImagen_url());

                return productoRepository.save(existeProducto);
            } else {
                throw new RuntimeException("Producto con ID " + id + " no encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el producto: " + e.getMessage(), e);
        }
    }
}
