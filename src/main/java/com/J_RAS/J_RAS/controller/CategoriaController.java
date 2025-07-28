package com.J_RAS.J_RAS.controller;


import com.J_RAS.J_RAS.dto.ProductoDTO;
import com.J_RAS.J_RAS.model.CategoriaModel;
import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.service.CategoriaService;
import com.J_RAS.J_RAS.service.ProductoService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
   private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaModel> listarCategorias(){
        List<CategoriaModel> categorias = this.categoriaService.listarCategoria();
        logger.info("Categorias obtenidas: ");
        categorias.forEach(categoria -> logger.info(categoria.toString()));
        return categorias;
    }
    @PostMapping
    public CategoriaModel agregarCategoria(@RequestBody CategoriaModel categoriaModel) {
        logger.info("Categoria a agregar: " + categoriaModel);
        CategoriaModel categoriaGuardada = this.categoriaService.guardarCategoria(categoriaModel);
        logger.info("Categoria guardada: " + categoriaGuardada);
        return categoriaGuardada;
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarCategoriaPorId(@PathVariable("id") Long id) {
        boolean ok = this.categoriaService.eliminarCategoriaPorId(id);
        if (ok) {
            return "Se eliminó la categoría con ID " + id;
        } else {
            return "No se pudo eliminar la categoría con ID " + id;
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> actualizarCategoriaPorId(@PathVariable Long id, @RequestBody CategoriaModel nuevoCategoria){
        try{
            CategoriaModel actualizarCategoria = categoriaService.actualizarCategoria(id, nuevoCategoria);
            if (actualizarCategoria != null){
                return new ResponseEntity<>(actualizarCategoria, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
