package com.api.stockManagerApp.categoria.domain.port.in;

import com.api.stockManagerApp.categoria.application.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaUseCase {

    List<CategoriaDTO> obtenerTodas();
    CategoriaDTO obtenerPorId(Long id);
    CategoriaDTO crear(CategoriaDTO dto);
    CategoriaDTO actualizar(Long id, CategoriaDTO dto);
    void eliminar(Long id);

}
