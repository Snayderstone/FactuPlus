package com.uce.FactuPlus.Services;

import com.uce.FactuPlus.Entities.Detalle;

import java.util.List;
import java.util.Optional;

public interface DetalleService {

    List<Detalle> findAll();

    Detalle findById(Long id);

    Detalle save(Detalle detalle);

    void deleteById(Long id);
}
