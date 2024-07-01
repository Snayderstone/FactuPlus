package com.uce.FactuPlus.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle")
public class Detalle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @Min(value = 1, message = "la cantidad debe al menos 1")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonIgnoreProperties("detalles")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
