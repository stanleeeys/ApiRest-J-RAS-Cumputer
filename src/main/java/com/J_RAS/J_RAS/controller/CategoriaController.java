package com.J_RAS.J_RAS.controller;


import com.J_RAS.J_RAS.model.CategoriaModel;
import com.J_RAS.J_RAS.service.CategoriaService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
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
    @GetMapping
    public CategoriaModel obtenerCategoriaPorId(Long idCategoria) {
        CategoriaModel categoria = this.categoriaService.buscarCategoriaPorId(idCategoria);
        if (categoria != null) {
            logger.info("Categoria obtenida: " + categoria);
            return categoria;
        } else {
            logger.warn("Categoria no encontrada con ID: " + idCategoria);
            return null;
        }
    }
    @PostMapping
    public CategoriaModel agregarCategoria(CategoriaModel categoriaModel) {
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

}
