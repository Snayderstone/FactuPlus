package com.uce.FactuPlus.Controllers;

import com.uce.FactuPlus.Entities.Producto;

import com.uce.FactuPlus.Services.ProductoService;
import com.uce.FactuPlus.Services.ProductoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setIdProducto(id);
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteById(id);
    }

//    private final ProductoService productoService;
//
//    @Autowired
//    public ProductoController(ProductoService productoService) {
//        this.productoService = productoService;
//    }
//
//    //GET Todas los productos
//    @GetMapping
//    public ResponseEntity<List<Producto>> findAllProductos() {
//        List<Producto> productos = productoService.findAll();
//        return new ResponseEntity<>(productos, HttpStatus.OK);
//    }
//
//    //GET Un producto por id
//    @GetMapping("/{id}")
//    public ResponseEntity<Producto> findByIdProducto(@PathVariable Long id) {
//        return productoService.findById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    //POST Crear un producto
//    @PostMapping
//    public ResponseEntity<Producto> createProducto(@Valid @RequestBody Producto producto) {
//        Producto newProducto = productoService.save(producto);
//        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
//    }
//
//    //PUT Actualizar un producto
//    @PutMapping("/{id}")
//    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @Valid @RequestBody Producto productoDetails) {
//        Optional<Producto> producto = productoService.findById(id);
//        if (producto.isPresent()) {
//            Producto updatedProducto = producto.get();
//            updatedProducto.setNombre(productoDetails.getNombre());
//            updatedProducto.setPrecio(productoDetails.getPrecio());
//            updatedProducto.setStock(productoDetails.getStock());
//            updatedProducto.setCategoria(productoDetails.getCategoria());
//            productoService.save(updatedProducto);
//            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //DELETE Eliminar un producto
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
//        productoService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
