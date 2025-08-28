package com.J_RAS.J_RAS.repository;

import com.J_RAS.J_RAS.model.CarritoModel;
import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoRepository extends JpaRepository<CarritoModel, Long> {
    List<CarritoModel> findByUsuario(Usuarios usuarioId);
    List<CarritoModel> findByProducto(ProductosModel productoId);

}
