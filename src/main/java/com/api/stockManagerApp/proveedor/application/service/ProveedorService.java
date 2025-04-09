package com.api.stockManagerApp.proveedor.application.service;

import com.api.stockManagerApp.proveedor.application.dto.ProveedorDTO;
import com.api.stockManagerApp.proveedor.domain.model.Proveedor;
import com.api.stockManagerApp.proveedor.domain.port.in.ProveedorUseCase;
import com.api.stockManagerApp.proveedor.domain.port.out.ProveedorRepositoryPort;
import com.api.stockManagerApp.proveedor.infrastructure.mapper.ProveedorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProveedorService implements ProveedorUseCase {

    private final ProveedorRepositoryPort repository;
    private final ProveedorMapper mapper;


    @Override
    public List<ProveedorDTO> obtenerTodos() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProveedorDTO obtenerPorId(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    public ProveedorDTO crear(ProveedorDTO dto) {
        Proveedor proveedor = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(proveedor));
    }

    @Override
    public ProveedorDTO actualizar(Long id, ProveedorDTO dto) {
        Proveedor proveedor = mapper.toEntity(dto);
        proveedor.setId(id);
        return mapper.toDTO(repository.save(proveedor));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
