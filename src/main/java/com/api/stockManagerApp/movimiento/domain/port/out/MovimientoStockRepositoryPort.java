package com.api.stockManagerApp.movimiento.domain.port.out;

import com.api.stockManagerApp.movimiento.domain.model.MovimientoStock;

import java.util.List;
import java.util.Optional;

public interface MovimientoStockRepositoryPort {

    List<MovimientoStock> findAll();
    Optional<MovimientoStock> findById(Long id);
    MovimientoStock save(MovimientoStock movimiento);

}
