package com.uce.FactuPlus.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "cliente")
public class Cliente  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre del cliente debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotEmpty(message = "El apellido del cliente no puede estar vacío")
    @Size(min = 3, max = 50, message = "El apellido del cliente debe tener entre 3 y 50 caracteres")
    private String apellido;

    @NotEmpty(message = "La dirección del cliente no puede estar vacía")
    @Size(min = 3, max = 100, message = "La dirección del cliente debe tener entre 3 y 50 caracteres")
    private String direccion;

    private Date fechaNacimiento;

    @NotEmpty(message = "El telefono del cliente no puede estar vacío")
    @Size(min = 10, max = 10, message = "El telefono del cliente debe tener 10 caracteres")
    private String telefono;

    @NotEmpty(message = "El email del cliente no puede estar vacío")
    @Email(message = "El email del cliente no es válido")
    @Column(unique = true)
    private String email;
}
