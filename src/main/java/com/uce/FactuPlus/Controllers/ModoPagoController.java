package com.uce.FactuPlus.Controllers;

import com.uce.FactuPlus.Entities.Factura;
import com.uce.FactuPlus.Entities.ModoPago;
import com.uce.FactuPlus.Services.FacturaService;
import com.uce.FactuPlus.Services.ModoPagoService;
import com.uce.FactuPlus.Services.ModoPagoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/modopagos")
public class ModoPagoController {

    @Autowired
    private ModoPagoService modoPagoService;

    @GetMapping
    public List<ModoPago> getAllModosPago() {
        return modoPagoService.findAll();
    }

    @GetMapping("/{id}")
    public ModoPago getModoPagoById(@PathVariable Long id) {
        return modoPagoService.findById(id);
    }

    @PostMapping
    public ModoPago createModoPago(@RequestBody ModoPago modoPago) {
        return modoPagoService.save(modoPago);
    }

    @PutMapping("/{id}")
    public ModoPago updateModoPago(@PathVariable Long id, @RequestBody ModoPago modoPago) {
        modoPago.setIdModoPago(id);
        return modoPagoService.save(modoPago);
    }

    @DeleteMapping("/{id}")
    public void deleteModoPago(@PathVariable Long id) {
        modoPagoService.deleteById(id);
    }

//    private final ModoPagoService modoPagoService;
//
//    @Autowired
//    public ModoPagoController(ModoPagoService modoPagoService) {
//        this.modoPagoService = modoPagoService;
//    }
//
//    //GET Todas las modos de pago
//    @GetMapping
//    public ResponseEntity<List<ModoPago>> findAllModosPago() {
//        List<ModoPago> modosPago = modoPagoService.findAll();
//        return new ResponseEntity<>(modosPago, HttpStatus.OK);
//    }
//
//    //GET Un modo de pago por id
//    @GetMapping("/{id}")
//    public ResponseEntity<ModoPago> findByIdModoPago(@PathVariable Long id) {
//        Optional<ModoPago> modoPago = modoPagoService.findById(id);
//        return modoPago.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    //POST Crear un modo de pago
//    @PostMapping
//    public ResponseEntity<ModoPago> createModoPago(@Valid @RequestBody ModoPago modoPago) {
//        ModoPago newModoPago = modoPagoService.save(modoPago);
//        return new ResponseEntity<>(newModoPago, HttpStatus.CREATED);
//    }
//
//    //PUT Actualizar un modo de pago
//    @PutMapping("/{id}")
//    public ResponseEntity<ModoPago> updateModoPago(@PathVariable Long id, @Valid @RequestBody ModoPago modoPagoDetails) {
//        Optional<ModoPago> modoPago = modoPagoService.findById(id);
//        if (modoPago.isPresent()) {
//            ModoPago updatedModoPago = modoPago.get();
//            updatedModoPago.setNombre(modoPagoDetails.getNombre());
//            updatedModoPago.setOtrosDetalles(modoPagoDetails.getOtrosDetalles());
//            modoPagoService.save(updatedModoPago);
//            return new ResponseEntity<>(updatedModoPago, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //DELETE Eliminar un modo de pago
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteModoPago(@PathVariable Long id) {
//        modoPagoService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    //GET Todas las facturas de un modo de pago
//    @GetMapping("/{id}/facturas")
//    public ResponseEntity<List<Factura>> getFacturasByModoPagoId(@PathVariable Long id) {
//        Optional<ModoPago> modoPago = modoPagoService.findById(id);
//        return modoPago.map(pago -> new ResponseEntity<>(pago.getFacturas(),
//                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

}

