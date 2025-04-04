package com.api.stockManagerApp.producto.infrastructure.mapper;

import com.api.stockManagerApp.producto.application.dto.ProductoDTO;
import com.api.stockManagerApp.producto.domain.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoDTO toDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStockActual(producto.getStockActual());
        dto.setIdCategoria(producto.getIdCategoria());
        return dto;
    }

    public Producto toEntity(ProductoDTO dto) {
        return Producto.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .stockActual(dto.getStockActual())
                .idCategoria(dto.getIdCategoria())
                .build();
    }

}
