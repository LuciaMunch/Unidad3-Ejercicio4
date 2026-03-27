package com.programacion4.unidad3ej4.feature.producto.controllers.patch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej4.config.BaseResponse;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoPatchRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoPatchService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoPatchController {

    private final IProductoPatchService productoPatchService;

    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> patch(
            @PathVariable Long id,
            @RequestBody ProductoPatchRequestDto dto) {

        ProductoResponseDto productoActualizado = productoPatchService.patch(id, dto);

        // US05: 200 OK
        return ResponseEntity.ok(
                BaseResponse.ok(productoActualizado, "Producto actualizado parcialmente"));
    }
}
