package com.J_RAS.J_RAS.repository;

import com.J_RAS.J_RAS.model.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuariosModel, Long> {
    Optional<UsuariosModel> findByEmail(String email);

}
