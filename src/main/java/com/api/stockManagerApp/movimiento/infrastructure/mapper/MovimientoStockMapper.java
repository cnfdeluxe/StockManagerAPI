package com.api.stockManagerApp.movimiento.infrastructure.mapper;

import com.api.stockManagerApp.movimiento.application.dto.MovimientoStockDTO;
import com.api.stockManagerApp.movimiento.domain.model.MovimientoStock;
import org.springframework.stereotype.Component;

@Component
public class MovimientoStockMapper {

    public MovimientoStockDTO toDTO(MovimientoStock movimiento) {
        MovimientoStockDTO dto = new MovimientoStockDTO();
        dto.setId(movimiento.getId());
        dto.setIdProducto(movimiento.getIdProducto());
        dto.setCantidad(movimiento.getCantidad());
        dto.setTipo(movimiento.getTipo().name());
        dto.setReferencia(movimiento.getReferencia());
        return dto;
    }

    public MovimientoStock toEntity(MovimientoStockDTO dto) {
        return MovimientoStock.builder()
                .id(dto.getId())
                .idProducto(dto.getIdProducto())
                .cantidad(dto.getCantidad())
                .tipo(MovimientoStock.TipoMovimiento.valueOf(dto.getTipo()))
                .referencia(dto.getReferencia())
                .build();
    }

}
