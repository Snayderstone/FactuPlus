package com.uce.FactuPlus.Controllers;
import com.uce.FactuPlus.Entities.Detalle;
import com.uce.FactuPlus.Repositories.DetalleRepository;
import com.uce.FactuPlus.Services.DetalleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/detalles")
public class DetalleController {

    @Autowired
    private DetalleService detalleFacturaService;

    @GetMapping
    public List<Detalle> getAllDetallesFactura() {
        return detalleFacturaService.findAll();
    }

    @GetMapping("/{id}")
    public Detalle getDetalleFacturaById(@PathVariable Long id) {
        return detalleFacturaService.findById(id);
    }

    @PostMapping
    public Detalle createDetalleFactura(@RequestBody Detalle detalleFactura) {
        return detalleFacturaService.save(detalleFactura);
    }

    @PutMapping("/{id}")
    public Detalle updateDetalleFactura(@PathVariable Long id, @RequestBody Detalle detalleFactura) {
        detalleFactura.setIdDetalle(id);
        return detalleFacturaService.save(detalleFactura);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleFactura(@PathVariable Long id) {
        detalleFacturaService.deleteById(id);
    }

//    private final DetalleService detalleService;
//
//    @Autowired
//    public DetalleController(DetalleService detalleService) {
//        this.detalleService = detalleService;
//    }
//
//    //GET Todas las detalles
//    @GetMapping
//    public ResponseEntity<List<Detalle>> findAllDetalles() {
//        List<Detalle> detalles = detalleService.findAll();
//        return new ResponseEntity<>(detalles, HttpStatus.OK);
//    }
//
//    //GET Un detalle por id
//    @GetMapping("/{id}")
//    public ResponseEntity<Detalle> findByIdDetalle(@PathVariable Long id) {
//        Detalle detalle = detalleService.findById(id).orElse(null);
//        return new ResponseEntity<>(detalle, HttpStatus.OK);
//    }
//
//    //POST Crear un detalle
//    @PostMapping
//    public ResponseEntity<Detalle> createDetalle(@Valid @RequestBody Detalle detalle) {
//        Detalle newDetalle = detalleService.save(detalle);
//        return new ResponseEntity<>(newDetalle, HttpStatus.CREATED);
//    }
//
//    //PUT Actualizar un detalle
//    @PutMapping("/{id}")
//    public ResponseEntity<Detalle> updateDetalle(@PathVariable Long id, @Valid @RequestBody Detalle detalleDetails) {
//        Optional<Detalle> detalle = detalleService.findById(id);
//        if (detalle.isPresent()) {
//            Detalle updatedDetalle = detalle.get();
//            updatedDetalle.setCantidad(detalleDetails.getCantidad());
//            updatedDetalle.setPrecio(detalleDetails.getPrecio());
//            updatedDetalle.setFactura(detalleDetails.getFactura());
//            updatedDetalle.setProducto(detalleDetails.getProducto());
//            detalleService.save(updatedDetalle);
//            return new ResponseEntity<>(updatedDetalle, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //DELETE Eliminar un detalle
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteDetalle(@PathVariable Long id) {
//        detalleService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
