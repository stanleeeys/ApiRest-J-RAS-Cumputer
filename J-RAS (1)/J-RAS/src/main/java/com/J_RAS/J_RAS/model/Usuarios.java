package com.J_RAS.J_RAS.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name ="usuarios")
public class Usuarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String contrasena;


    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
