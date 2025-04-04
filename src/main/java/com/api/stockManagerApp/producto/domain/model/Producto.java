package com.api.stockManagerApp.producto.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
    @Column(name = "stock_actual", nullable = false)
    private Integer stockActual;
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;


    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

}
