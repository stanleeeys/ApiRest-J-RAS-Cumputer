package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductosModel>listarProductos(){
        return this.productoRepository.findAll();
    }

    @Override
    public ProductosModel buscarProductoPorId(Long id){
        ProductosModel productosModel = this.productoRepository.findById(id).orElse(null);
        return productosModel;
    }
    @Override
    public ProductosModel guardarProducto(ProductosModel productosModel) {

        return productoRepository.save(productosModel);

    }
    @Override
    public void eliminarProductoPorId(Long id){
        this.productoRepository.deleteById(id);
    }

    @Override
    public  List<ProductosModel> buscarProductosPorNombre(String nombre){
       return productoRepository.findByNombreContainingIgnoreCase(nombre);
   }

   @Override
   public ProductosModel actualizarProductos (Long id, ProductosModel nuevoProducto) {
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
