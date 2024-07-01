package com.uce.FactuPlus.Controllers;

import com.uce.FactuPlus.Entities.Categoria;
import com.uce.FactuPlus.Entities.Producto;
import com.uce.FactuPlus.Services.CategoriaService;
import com.uce.FactuPlus.Services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(id);
        return categoriaService.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
    }

//    private final CategoriaService categoriaService;
//    private final ProductoService productoService;

//    @Autowired
//    public CategoriaController(CategoriaService categoriaService, ProductoService productoService) {
//        this.categoriaService = categoriaService;
//        this.productoService = productoService;
//    }
//
//    //GET Todas las categorias
//    @GetMapping
//    public ResponseEntity<List<Categoria>> findAllCategorias() {
//        List<Categoria> categorias = categoriaService.findAll();
//        return new ResponseEntity<>(categorias, HttpStatus.OK);
//    }
//
//    //GET Una categoria por id
//    @GetMapping("/{id}")
//    public ResponseEntity<Categoria> findByIdCategoria(@PathVariable Long id) {
//        Optional<Categoria> categoria = categoriaService.findById(id);
//       return categoria.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    //POST Crear una categoria
//    @PostMapping
//    public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody Categoria categoria) {
//        Categoria newCategoria = categoriaService.save(categoria);
//        return new ResponseEntity<>(newCategoria, HttpStatus.CREATED);
//    }
//
//    //PUT Actualizar una categoria
//    @PutMapping("/{id}")
//    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @Valid @RequestBody Categoria categoriaDetails) {
//        Optional<Categoria> categoria = categoriaService.findById(id);
//        if (categoria.isPresent()) {
//            Categoria updatedCategoria = categoria.get();
//            updatedCategoria.setNombre(categoriaDetails.getNombre());
//            updatedCategoria.setDescripcion(categoriaDetails.getDescripcion());
//            categoriaService.save(updatedCategoria);
//            return new ResponseEntity<>(updatedCategoria, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //DELETE Eliminar una categoria
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
//        categoriaService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    //GET Todas las productos de una categoria
//    @GetMapping("/{id}/productos")
//    public ResponseEntity<List<Producto>> getProductosByCategoriaId(@PathVariable Long id) {
//        Optional<Categoria> categoria = categoriaService.findById(id);
//        return categoria.map(value -> new ResponseEntity<>(value.getProductos(),
//                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    //POST Crear un producto en una categoria
//    @PostMapping("/{id}/productos")
//    public ResponseEntity<Producto> createProducto(@PathVariable Long id, @Valid @RequestBody Producto producto) {
//        Optional<Categoria> categoria = categoriaService.findById(id);
//        if (categoria.isPresent()) {
//            producto.setCategoria(categoria.get());
//            Producto newProducto = productoService.save(producto);
//            return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


}
