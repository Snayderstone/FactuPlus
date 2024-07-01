package com.uce.FactuPlus.Services;

import com.uce.FactuPlus.Entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> findAll();

    Categoria findById(Long id);

    Categoria save(Categoria categoria);

    void deleteById(Long id);
}
