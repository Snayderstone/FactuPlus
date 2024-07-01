package com.uce.FactuPlus.Controllers;

import com.uce.FactuPlus.Entities.Cliente;
import com.uce.FactuPlus.Entities.Factura;
import com.uce.FactuPlus.Services.ClienteService;
import com.uce.FactuPlus.Services.ClienteServiceImpl;
import com.uce.FactuPlus.Services.FacturaService;
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
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private  ClienteService clienteService;
    private  FacturaService facturaService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
    }

    //GET Todas las clientes
//    @GetMapping
//    public ResponseEntity<List<Cliente>> findAllClientes() {
//        List<Cliente> clientes = clienteService.findAll();
//        return new ResponseEntity<>(clientes, HttpStatus.OK);
//    }
//
//    //GET Un cliente por id
//    @GetMapping("/{id}")
//    public Cliente getClienteById(@PathVariable Long id) {
//        return clienteService.findById(id);
//    }
//
//    //POST Crear un cliente
//    @PostMapping
//    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente) {
//        Cliente newCliente = clienteService.save(cliente);
//        return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
//    }
//
//    //PUT Actualizar un cliente
//    @PutMapping("/{id}")
//    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @Valid @RequestBody Cliente clienteDetails) {
//        Optional<Cliente> cliente = clienteService.findById(id);
//        if (cliente.isPresent()) {
//            Cliente updatedCliente = cliente.get();
//            updatedCliente.setNombre(clienteDetails.getNombre());
//            updatedCliente.setApellido(clienteDetails.getApellido());
//            updatedCliente.setDireccion(clienteDetails.getDireccion());
//            updatedCliente.setTelefono(clienteDetails.getTelefono());
//            updatedCliente.setEmail(clienteDetails.getEmail());
//            updatedCliente.setFechaNacimiento(clienteDetails.getFechaNacimiento());
//            clienteService.save(updatedCliente);
//            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //DELETE Eliminar un cliente
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
//        clienteService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

//    //GET Todas las facturas de un cliente
//    @GetMapping("/{id}/facturas")
//    public ResponseEntity<List<Factura>> getFacturasByClienteId(@PathVariable Long id) {
//        Optional<Cliente> cliente = clienteService.findById(id);
//        return cliente.map(value -> new ResponseEntity<>(value.getFacturas(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    //POST Crear una factura para un cliente
//    @PostMapping("/{id}/facturas")
//    public ResponseEntity<Factura> createFactura(@PathVariable Long id, @Valid @RequestBody Factura factura) {
//        Optional<Cliente> cliente = clienteService.findById(id);
//        if (cliente.isPresent()) {
//            factura.setCliente(cliente.get());
//            Factura newFactura = facturaService.save(factura);
//            return new ResponseEntity<>(newFactura, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }



}
