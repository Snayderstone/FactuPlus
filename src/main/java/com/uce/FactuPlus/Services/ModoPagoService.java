package com.uce.FactuPlus.Services;

import com.uce.FactuPlus.Entities.ModoPago;

import java.util.List;
import java.util.Optional;

public interface ModoPagoService {

    List<ModoPago> findAll();

    ModoPago findById(Long id);

    ModoPago save(ModoPago modoPago);

    void deleteById(Long id);
}
