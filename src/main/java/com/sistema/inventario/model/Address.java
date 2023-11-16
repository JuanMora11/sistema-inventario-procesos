package com.sistema.inventario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "street address is required")
    @Size(max = 100, message = "Street address max 100 characters")
    private String streetAddress;
    @NotNull(message = "city is required")
    @Size(max = 100, message = "city max 100 characters")
    private  String city;
    @NotNull(message = "state is required")
    @Size(max = 100, message = "state max 100 characters")
    private String state;
    @NotNull(message = "postal code is required")
    @Size(min = 1, max = 10, message = "postal code max 10 characters")
    private String postalCode;
    @JsonIgnore
    private Boolean status = Boolean.TRUE;
    @ManyToOne
    @JoinColumn(name = "idUser",referencedColumnName = "id")
    private User user;
}
