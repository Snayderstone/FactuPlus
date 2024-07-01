package com.uce.FactuPlus.Repositories;

import com.uce.FactuPlus.Entities.ModoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoPagoRepository  extends JpaRepository<ModoPago, Long> {
}
