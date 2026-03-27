package com.programacion4.unidad3ej4.feature.producto.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoUpdateRequestDto {

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El código es requerido")
    private String codigo;

    @NotBlank(message = "La descripción es requerida")
    private String descripcion;

    @NotNull(message = "El precio es requerido")
    private Double precio;

    @NotNull(message = "El stock es requerido")
    private Integer stock;

    @NotNull(message = "La categoría es requerida")
    private Long categoriaId;
}
