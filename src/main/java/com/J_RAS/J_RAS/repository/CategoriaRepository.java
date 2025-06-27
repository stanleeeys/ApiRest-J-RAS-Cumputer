package com.J_RAS.J_RAS.repository;

import com.J_RAS.J_RAS.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

}
