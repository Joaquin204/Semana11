package com.ejemplo.laboratorio11.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Producto disponible en el catálogo")
@Entity
@Table(name = "producto")
public class Producto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY,
            description = "Identificador generado por la base de datos")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(example = "Laptop Lenovo",
            description = "Nombre comercial del producto")
    private String nombre;

    @Schema(example = "2500.00",
            description = "Precio de venta")
    private double precio;

    @Schema(example = "10",
            description = "Unidades disponibles")
    private int stock;

    @Transient
    @Schema(accessMode = Schema.AccessMode.READ_ONLY,
            example = "OK")
    public String getEstadoStock() {
        return stock < 5 ? "INSUFICIENTE" : "OK";
    }
}

