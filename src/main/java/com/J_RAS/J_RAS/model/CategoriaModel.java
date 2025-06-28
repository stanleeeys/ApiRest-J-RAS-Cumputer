package com.J_RAS.J_RAS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name ="categorias")
@ToString(exclude = "productos")

public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String imagen_url;

    @OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductosModel> productos;
}
