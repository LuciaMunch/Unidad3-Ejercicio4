package com.programacion4.unidad3ej4.feature.producto.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * DTO para actualización parcial (PATCH).
 * Todos los campos son opcionales: solo se actualizan los que llegan no-nulos.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoPatchRequestDto {

    private Double precio;

    private Integer stock;

    private Long categoriaId;
}
