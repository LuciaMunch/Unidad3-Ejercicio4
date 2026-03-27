package com.programacion4.unidad3ej4.feature.producto.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoUpdateRequestDto {

    private String nombre;

    private String codigo;

    private String descripcion;

    private Double precio;

    private Integer stock;

    private Long categoriaId;
}
