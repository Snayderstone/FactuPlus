package com.uce.FactuPlus.Entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @NotEmpty(message = "El nombre de la categoria no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "El descripción de la categoria no puede estar vacío")
    private String descripcion;

}
