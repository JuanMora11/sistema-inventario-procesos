package com.sistema.inventario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @NotBlank(message = "Name category is required")
    @Size(max = 100, message = "Name category max 100 characters")
    private String nameCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Article> articuloList;
}