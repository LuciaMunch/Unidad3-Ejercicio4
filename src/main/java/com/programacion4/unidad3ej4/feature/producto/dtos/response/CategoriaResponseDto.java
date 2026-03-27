package com.programacion4.unidad3ej4.feature.producto.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaResponseDto {
    
    private Long id;

    private String nombre;

}
