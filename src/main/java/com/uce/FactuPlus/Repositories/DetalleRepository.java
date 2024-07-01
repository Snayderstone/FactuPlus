package com.uce.FactuPlus.Repositories;

import com.uce.FactuPlus.Entities.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository  extends JpaRepository<Detalle, Long> {
}

