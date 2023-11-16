package com.sistema.inventario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name is required")
    @Size(max = 100, message = "name max 100 characters")
    private String name;
    @NotNull(message = "price is required")
    @Size(max = 10, message = "price max 10 characters")
    private String price;
    @NotNull(message = "description is required")
    @Size(max = 100, message = "description max 100 characters")
    private String description;
    @NotNull(message = "color is required")
    @Size(max = 50, message = "name max 50 characters")
    private String color;
    @NotNull(message = "material is required")
    @Size(max = 50, message = "name max 50 characters")
    private String material;
    @NotNull(message = "quantity is required")
    @Size(max = 100, message = "quantity max 100 characters")
    private String quantity;
    @ManyToOne()
    @JoinColumn(name="id_Category", referencedColumnName = "idCategory")
    private Category category;
    /*@JsonIgnore
    @OneToMany(mappedBy = "article")
    private List<Category> category;*/
}

