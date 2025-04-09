package com.api.stockManagerApp.movimiento.domain.port.in;

import com.api.stockManagerApp.movimiento.application.dto.MovimientoStockDTO;

import java.util.List;

public interface MovimientoStockUseCase {

    List<MovimientoStockDTO> obtenerTodos();
    MovimientoStockDTO obtenerPorId(Long id);
    MovimientoStockDTO registrar(MovimientoStockDTO dto);

}
