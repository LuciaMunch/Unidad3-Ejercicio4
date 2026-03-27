package com.programacion4.unidad3ej4.feature.producto.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoResponseDto {
    
    private Long id;

    private String nombre;

    private String codigo;

    private String descripcion;

    private Double precio;

    private Integer stock;

    private CategoriaResponseDto categoria;
}
