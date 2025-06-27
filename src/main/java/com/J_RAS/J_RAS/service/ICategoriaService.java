package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.CategoriaModel;

import java.util.List;

public interface ICategoriaService {
    public List<CategoriaModel> listarCategoria();

    public CategoriaModel buscarCategoriaPorId(Long idCategoria);

    public CategoriaModel guardarCategoria(CategoriaModel categoriaModel);

    void eliminarCategoriaPorId(Long idCategoria);

    public CategoriaModel actualizarCategoria (Long idCategoria, CategoriaModel categoriaActualizada);
}
