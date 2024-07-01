package com.uce.FactuPlus.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "modoPago")
public class ModoPago  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModoPago;

    @NotEmpty(message = "El nombre del modo de pago no puede estar vacío")
    private String nombre;
}
