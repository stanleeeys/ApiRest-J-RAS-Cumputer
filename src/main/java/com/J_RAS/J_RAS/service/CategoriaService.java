package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.CategoriaModel;
import com.J_RAS.J_RAS.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class CategoriaService  implements  ICategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaModel>listarCategoria(){
        return this.categoriaRepository.findAll();

    }
    @Override
    public CategoriaModel buscarCategoriaPorId(Long idCategoria){
        CategoriaModel categoriaModel = this.categoriaRepository.findById(idCategoria).orElse(null);
        return categoriaModel;
    }
    @Override
    public CategoriaModel guardarCategoria(CategoriaModel categoriaModel) {
        return categoriaRepository.save(categoriaModel);

    }
    @Override
    public void eliminarCategoriaPorId(Long idCategoria){
        this.categoriaRepository.deleteById(idCategoria);
    }
    @Override
    public CategoriaModel actualizarCategoria(Long idCategoria, CategoriaModel categoriaActualizados){
        CategoriaModel categoriaExistente = categoriaRepository.findById(idCategoria)
                .orElseThrow(()-> new RuntimeException("Catgeoria no encontrado con ID: " + idCategoria ));

        categoriaExistente.setNombre(categoriaActualizados.getNombre());
        categoriaExistente.setImagen_url(categoriaActualizados.getImagen_url());


        return categoriaRepository.save(categoriaExistente);
    }


}
