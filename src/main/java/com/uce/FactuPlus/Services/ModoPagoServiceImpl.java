package com.uce.FactuPlus.Services;
import com.uce.FactuPlus.Entities.ModoPago;
import com.uce.FactuPlus.Repositories.ModoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModoPagoServiceImpl implements ModoPagoService {

    @Autowired
    private  ModoPagoRepository modoPagoRepository;


    @Override
    public List<ModoPago> findAll() {
        return modoPagoRepository.findAll();
    }

    @Override
    public ModoPago findById(Long id) {
        return modoPagoRepository.findById(id).orElse(null);
    }

    @Override
    public ModoPago save(ModoPago modoPago) {
        return modoPagoRepository.save(modoPago);
    }

    @Override
    public void deleteById(Long id) {
        modoPagoRepository.deleteById(id);
    }


}
