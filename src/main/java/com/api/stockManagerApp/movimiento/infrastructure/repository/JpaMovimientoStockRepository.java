package com.api.stockManagerApp.movimiento.infrastructure.repository;

import com.api.stockManagerApp.movimiento.domain.model.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovimientoStockRepository extends JpaRepository<MovimientoStock, Long> {


}
