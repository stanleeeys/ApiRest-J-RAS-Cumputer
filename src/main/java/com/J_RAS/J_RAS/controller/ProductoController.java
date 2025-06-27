package com.J_RAS.J_RAS.controller;


import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.service.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private IProductoService productoServicio;

    @GetMapping
    public List<ProductosModel> listarProductos(){
        List<ProductosModel> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping
    public ProductosModel agregarProducto(@RequestBody ProductosModel productosModel){
        logger.info("Producto a agregar: " + productosModel);
        this.productoServicio.guardarProducto(productosModel);
        return productosModel;
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductosModel> actualizarProducto(@PathVariable Long id, @RequestBody ProductosModel nuevoProducto){
        try{
            ProductosModel actualizarProductos = productoServicio.actualizarProductos(id, nuevoProducto);
            if (actualizarProductos != null){
                return new ResponseEntity<>(actualizarProductos, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
