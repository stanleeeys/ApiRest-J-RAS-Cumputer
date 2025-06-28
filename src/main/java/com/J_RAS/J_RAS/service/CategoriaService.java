package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.CategoriaModel;
import com.J_RAS.J_RAS.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<CategoriaModel>listarCategoria(){
        return this.categoriaRepository.findAll();

    }

    public CategoriaModel buscarCategoriaPorId(Long idCategoria){
        CategoriaModel categoriaModel = this.categoriaRepository.findById(idCategoria).orElse(null);
        return categoriaModel;
    }

    public CategoriaModel guardarCategoria(CategoriaModel categoriaModel) {
        return categoriaRepository.save(categoriaModel);

    }

    public boolean eliminarCategoriaPorId(Long id) {
        try {
            categoriaRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

    public CategoriaModel actualizarCategoria(Long idCategoria, CategoriaModel categoriaActualizados){
        CategoriaModel categoriaExistente = categoriaRepository.findById(idCategoria)
                .orElseThrow(()-> new RuntimeException("Catgeoria no encontrado con ID: " + idCategoria ));

        categoriaExistente.setNombre(categoriaActualizados.getNombre());
        categoriaExistente.setImagen_url(categoriaActualizados.getImagen_url());


        return categoriaRepository.save(categoriaExistente);
    }


}
