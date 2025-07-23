package com.J_RAS.J_RAS.repository;

import com.J_RAS.J_RAS.model.ProductosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductosModel, Long> {
    List<ProductosModel> findByNombreContainingIgnoreCase(String nombre);

}
