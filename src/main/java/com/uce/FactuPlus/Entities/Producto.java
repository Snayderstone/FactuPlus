package com.uce.FactuPlus.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;



@Data
@Entity
@Table(name = "producto")
public class Producto  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @NotEmpty(message = "El nombre del producto no puede estar vacío")
    private String nombre;

    @DecimalMin(value = "0.01", message = "El precio del producto debe ser mayor a 0.01")
    private double precio;

    @Min(value = 1, message = "El stock del producto debe ser mayor a 1")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
