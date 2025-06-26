package com.J_RAS.J_RAS.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
