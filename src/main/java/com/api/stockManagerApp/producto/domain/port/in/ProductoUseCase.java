package com.api.stockManagerApp.producto.domain.port.in;

import com.api.stockManagerApp.producto.application.dto.ProductoDTO;

import java.util.List;

public interface ProductoUseCase {

    List<ProductoDTO> obtenerTodos();
    ProductoDTO obtenerPorId(Long id);
    ProductoDTO crear(ProductoDTO producto);
    ProductoDTO actualizar(Long id, ProductoDTO producto);
    void eliminar(Long id);

}
