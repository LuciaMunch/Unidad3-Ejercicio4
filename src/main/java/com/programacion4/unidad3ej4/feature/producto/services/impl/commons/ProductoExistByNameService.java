package com.programacion4.unidad3ej4.feature.producto.services.impl.commons;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.IProductoExistByNameService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoExistByNameService implements IProductoExistByNameService {

    private final IProductoRepository productoRepository;
    
    @Override
    public boolean existByName(String nombre) {
        return productoRepository.existsByNombre(nombre);
    }
}
