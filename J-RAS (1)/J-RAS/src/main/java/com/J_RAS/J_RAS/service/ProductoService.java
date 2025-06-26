package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.Productos;
import com.J_RAS.J_RAS.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Productos>listarProductos(){
        return this.productoRepository.findAll();
    }
    @Override
    public Productos buscarProductoPorId(Long idProducto){
        Productos productos = this.productoRepository.findById(idProducto).orElse(null);
        return productos;
    }
    @Override
    public Productos guardarProducto(Productos productos) {

        return productoRepository.save(productos);

    }
    @Override
    public void eliminarProductoPorId(Long idProducto){
        this.productoRepository.deleteById(idProducto);
    }
    @Override
   public  List<Productos> buscarProductosPorNombre(String nombre){
       return productoRepository.findByNombreContainingIgnoreCase(nombre);
   }
   @Override
    public Productos actualizarProductos(Long idProducto, Productos productoActualizado){
        Productos productosExistente = productoRepository.findById(idProducto)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado con ID: " + idProducto ));

       productosExistente.setNombre(productoActualizado.getNombre());
       productosExistente.setDescripcion(productoActualizado.getDescripcion());
       productosExistente.setPrecio(productoActualizado.getPrecio());
       productosExistente.setImagen_url(productoActualizado.getImagen_url());
       productosExistente.setCategorias(productoActualizado.getCategorias());

       return productoRepository.save(productosExistente);
   }

}
