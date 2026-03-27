package com.programacion4.unidad3ej4.feature.producto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programacion4.unidad3ej4.feature.producto.models.Categoria;

@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Long> {
    
}
