package com.uce.FactuPlus.Controllers;

import com.uce.FactuPlus.Entities.Detalle;
import com.uce.FactuPlus.Entities.Factura;
import com.uce.FactuPlus.Services.DetalleService;
import com.uce.FactuPlus.Services.FacturaService;
import com.uce.FactuPlus.Services.FacturaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Long id) {
        return facturaService.findById(id);
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        factura.setIdFactura(id);
        return facturaService.save(factura);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id) {
        facturaService.deleteById(id);
    }

//    private final FacturaService facturaService;
//    private final DetalleService detalleService;
//
//    @Autowired
//    public FacturaController(FacturaService facturaService, DetalleService detalleService) {
//        this.facturaService = facturaService;
//        this.detalleService = detalleService;
//    }
//
//    //GET Todas las facturas
//    @GetMapping
//    public ResponseEntity<List<Factura>> findAllFacturas() {
//        List<Factura> facturas = facturaService.findAll();
//        return new ResponseEntity<>(facturas, HttpStatus.OK);
//    }
//
//    //GET Un factura por id
//    @GetMapping("/{id}")
//    public ResponseEntity<Factura> findByIdFactura(@PathVariable Long id) {
//        return facturaService.findById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    //POST Crear una factura
//    @PostMapping
//    public ResponseEntity<Factura> createFactura(@Valid @RequestBody Factura factura) {
//        Factura newFactura = facturaService.save(factura);
//        return new ResponseEntity<>(newFactura, HttpStatus.CREATED);
//    }
//
//    //PUT Actualizar una factura
//    @PutMapping("/{id}")
//    public ResponseEntity<Factura> updateFactura(@PathVariable Long id, @Valid @RequestBody Factura facturaDetails) {
//        Optional<Factura> factura = facturaService.findById(id);
//        if (factura.isPresent()) {
//            Factura updatedFactura = factura.get();
//            updatedFactura.setFecha(facturaDetails.getFecha());
//            updatedFactura.setCliente(facturaDetails.getCliente());
//            updatedFactura.setModoPago(facturaDetails.getModoPago());
//            facturaService.save(updatedFactura);
//            return new ResponseEntity<>(updatedFactura, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //DELETE Eliminar una factura
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFactura(@PathVariable Long id) {
//        facturaService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    //GET Todas las detalles de una factura
//    @GetMapping("/{id}/detalles")
//    public ResponseEntity<List<Detalle>> getDetallesByFacturaId(@PathVariable Long id) {
//        Optional<Factura> factura = facturaService.findById(id);
//        return factura.map(value -> new ResponseEntity<>(value.getDetalles(), HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    //POST Crear un detalle en una factura
//    @PostMapping("/{id}/detalles")
//    public ResponseEntity<Detalle> createDetalle(@PathVariable Long id, @Valid @RequestBody Detalle detalle) {
//        Optional<Factura> factura = facturaService.findById(id);
//        if (factura.isPresent()) {
//            detalle.setFactura(factura.get());
//            Detalle newDetalle = detalleService.save(detalle);
//            return new ResponseEntity<>(newDetalle, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
