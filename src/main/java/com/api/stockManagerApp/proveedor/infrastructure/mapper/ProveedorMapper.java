package com.api.stockManagerApp.proveedor.infrastructure.mapper;

import com.api.stockManagerApp.proveedor.application.dto.ProveedorDTO;
import com.api.stockManagerApp.proveedor.domain.model.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {

    public ProveedorDTO toDTO(Proveedor proveedor) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setId(proveedor.getId());
        dto.setNombre(proveedor.getNombre());
        dto.setContacto(proveedor.getContacto());
        dto.setTelefono(proveedor.getTelefono());
        dto.setEmail(proveedor.getEmail());
        return dto;
    }

    public Proveedor toEntity(ProveedorDTO dto) {
        return Proveedor.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .contacto(dto.getContacto())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .build();
    }


}
