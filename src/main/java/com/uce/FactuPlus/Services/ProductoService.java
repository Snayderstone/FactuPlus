package com.uce.FactuPlus.Services;

import com.uce.FactuPlus.Entities.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();

    Producto findById(Long id);

    Producto save(Producto producto);

    void deleteById(Long id);
}
