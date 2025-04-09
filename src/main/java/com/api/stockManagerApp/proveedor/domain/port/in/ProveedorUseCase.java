package com.api.stockManagerApp.proveedor.domain.port.in;

import com.api.stockManagerApp.proveedor.application.dto.ProveedorDTO;

import java.util.List;

public interface ProveedorUseCase {

    List<ProveedorDTO> obtenerTodos();
    ProveedorDTO obtenerPorId(Long id);
    ProveedorDTO crear(ProveedorDTO dto);
    ProveedorDTO actualizar(Long id, ProveedorDTO dto);
    void eliminar(Long id);


}
