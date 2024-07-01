package com.uce.FactuPlus.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "factura")
public class Factura  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "modo_pago_id")
    private ModoPago modoPago;

    @OneToMany(mappedBy = "factura")
    @JsonIgnoreProperties("factura")
    private List<Detalle> detalles;
}
