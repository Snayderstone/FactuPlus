package com.uce.FactuPlus.Services;
import com.uce.FactuPlus.Entities.Factura;
import com.uce.FactuPlus.Repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl  implements FacturaService {

    @Autowired
    private  FacturaRepository facturaRepository;


    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura findById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public void deleteById(Long id) {
    facturaRepository.deleteById(id);
    }
}


