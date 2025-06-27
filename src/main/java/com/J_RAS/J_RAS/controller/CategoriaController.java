package com.J_RAS.J_RAS.controller;


import com.J_RAS.J_RAS.model.CategoriaModel;
import com.J_RAS.J_RAS.service.CategoriaService;
import com.J_RAS.J_RAS.service.ICategoriaService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
   private ICategoriaService categoriaService;

    @GetMapping
    public List<CategoriaModel> listarCategorias(){
        List<CategoriaModel> categorias = this.categoriaService.listarCategoria();
        logger.info("Categorias obtenidas: ");
        categorias.forEach(categoria -> logger.info(categoria.toString()));
        return categorias;
    }

}
