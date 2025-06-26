package com.J_RAS.J_RAS.repository;

import com.J_RAS.J_RAS.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
    List<Productos> findByNombreContainingIgnoreCase(String nombre);
}
