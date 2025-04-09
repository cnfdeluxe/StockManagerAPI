package com.api.stockManagerApp.producto.domain.model;

import com.api.stockManagerApp.categoria.domain.model.Categoria;
import com.api.stockManagerApp.proveedor.domain.model.Proveedor;
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
    @Column(nullable = false, length = 150)
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
    @Column(name = "stock_actual", nullable = false)
    private Integer stockActual;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", insertable = false, updatable = false)
    private Proveedor proveedor;
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Column(name = "id_proveedor")
    private Long idProveedor;
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;


    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

}
