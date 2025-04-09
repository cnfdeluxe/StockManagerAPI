package com.api.stockManagerApp.movimiento.application.dto;

import lombok.Data;

@Data
public class MovimientoStockDTO {

    private Long id;
    private Long idProducto;
    private Integer cantidad;
    private String tipo; // ENTRADA o SALIDA
    private String referencia;

}
