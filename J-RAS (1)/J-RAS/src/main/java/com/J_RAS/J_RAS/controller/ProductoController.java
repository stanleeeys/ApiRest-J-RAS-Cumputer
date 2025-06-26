package com.J_RAS.J_RAS.controller;


import com.J_RAS.J_RAS.model.Productos;
import com.J_RAS.J_RAS.service.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Productos> listarProductos(){
        List<Productos> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping
    public Productos agregarProducto(@RequestBody Productos productos){
        logger.info("Producto a agregar: " + productos);
        this.productoServicio.guardarProducto(productos);
        return productos;
    }


}
