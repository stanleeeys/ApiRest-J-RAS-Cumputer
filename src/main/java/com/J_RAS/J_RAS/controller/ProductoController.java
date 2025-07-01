package com.J_RAS.J_RAS.controller;


import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductosModel> listarProductos(){
        List<ProductosModel> productos = this.productoService.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping
    public ProductosModel agregarProducto(@RequestBody ProductosModel productosModel){
        logger.info("Producto a agregar: " + productosModel);
        this.productoService.guardarProducto(productosModel);
        return productosModel;
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductosModel> actualizarProductoPorId(@PathVariable Long id, @RequestBody ProductosModel nuevoProducto){
        try{
            ProductosModel actualizarProductos = productoService.actualizarProductos(id, nuevoProducto);
            if (actualizarProductos != null){
                return new ResponseEntity<>(actualizarProductos, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarProductoPorId(@PathVariable("id")Long id){
        boolean ok = this.productoService.eliminarProductoPorId(id);
        if (ok){
            return "Se elimino el producto con id " + id;
        }else {
            return "no se pudo eliminar el producto con id" + id;
        }
    }
}
