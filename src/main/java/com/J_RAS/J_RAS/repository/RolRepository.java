package com.J_RAS.J_RAS.repository;

import com.J_RAS.J_RAS.model.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository  extends JpaRepository <RolModel, Long> {
    Optional<RolModel> findByNombre(String nombre);
}
