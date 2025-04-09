package com.api.stockManagerApp.producto.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stockActual;
    private Long idCategoria;
    private Long idProveedor;


}
