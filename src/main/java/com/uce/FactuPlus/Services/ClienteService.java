package com.uce.FactuPlus.Services;

import com.uce.FactuPlus.Entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    void deleteById(Long id);
}
