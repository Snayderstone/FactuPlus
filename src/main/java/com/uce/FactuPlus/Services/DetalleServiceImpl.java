package com.uce.FactuPlus.Services;

import com.uce.FactuPlus.Entities.Detalle;
import com.uce.FactuPlus.Repositories.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServiceImpl implements DetalleService {


    @Autowired
    private DetalleRepository detalleRepository;


    @Override
    public List<Detalle> findAll() {
        return detalleRepository.findAll();
    }

    @Override
    public Detalle findById(Long id) {
        return detalleRepository.findById(id).orElse(null);
    }

    @Override
    public Detalle save(Detalle detalle) {
        return detalleRepository.save(detalle);
    }

    @Override
    public void deleteById(Long id) {
        detalleRepository.deleteById(id);
    }
}
