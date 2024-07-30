package com.graphql.ejemplo.graphqljava.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphql.ejemplo.graphqljava.entities.Marca;
import com.graphql.ejemplo.graphqljava.entities.Producto;
import com.graphql.ejemplo.graphqljava.inputs.MarcaInput;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MarcaController {

    @QueryMapping
    public Marca getByIdMarca(@Argument String id) {
        log.info("indicando donde entra");
        return Marca.getByIdMarca(id);
    }

    @SchemaMapping
    public Marca marca(Producto producto) {
        return Marca.getByIdMarca(producto.marcaId());
    }

    @MutationMapping
    public Marca add(@Argument MarcaInput marcaInput) {
        return Marca.add(marcaInput);
    }
}
