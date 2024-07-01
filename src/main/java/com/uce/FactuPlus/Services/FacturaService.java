package com.uce.FactuPlus.Services;

import com.uce.FactuPlus.Entities.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    List<Factura> findAll();

    Factura findById(Long id);

    Factura save(Factura factura);

    void deleteById(Long id);
}
