package com.api.stockManagerApp.producto.application.service;

import com.api.stockManagerApp.producto.application.dto.ProductoDTO;
import com.api.stockManagerApp.producto.domain.model.Producto;
import com.api.stockManagerApp.producto.domain.port.in.ProductoUseCase;
import com.api.stockManagerApp.producto.domain.port.out.ProductoRepositoryPort;
import com.api.stockManagerApp.producto.infrastructure.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService implements ProductoUseCase {

    private final ProductoRepositoryPort repository;
    private final ProductoMapper mapper;


    @Override
    public List<ProductoDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public ProductoDTO crear(ProductoDTO productoDTO) {
        Producto producto = mapper.toEntity(productoDTO);
        return mapper.toDTO(repository.save(producto));
    }

    @Override
    public ProductoDTO actualizar(Long id, ProductoDTO productoDTO) {
        Producto producto = mapper.toEntity(productoDTO);
        producto.setId(id);
        return mapper.toDTO(repository.save(producto));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
