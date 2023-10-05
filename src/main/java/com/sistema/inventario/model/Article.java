//hello
package com.sistema.inventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String description;
    private String color;
    private String material;
    private String quantity;
    @ManyToOne
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
    private Category category;
}
