package com.graphql.ejemplo.graphqljava.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphql.ejemplo.graphqljava.dtos.MarcaProductoDTO;
import com.graphql.ejemplo.graphqljava.entities.Marca;
import com.graphql.ejemplo.graphqljava.entities.Producto;
import com.graphql.ejemplo.graphqljava.inputs.ProductoInput;

@Controller
public class ProductoController {

    @QueryMapping
    public List<Producto> getAllProductos() {
        return Producto.getAllProducto();
    }

    @QueryMapping
    public Producto getByIProducto(@Argument String id) {
        return Producto.getByIProducto(id);
    }

    @QueryMapping
    public MarcaProductoDTO getProductoByIdMarca(@Argument String idMarca) {
        List<Producto> resultSet = Producto.getProductoByIdMarca(idMarca);
        Marca marca = Marca.getByIdMarca(idMarca);
        return new MarcaProductoDTO(marca, resultSet);
    }

    @SchemaMapping
    public List<Producto> products(Marca marca) {
        return Producto.getProductoByIdMarca(marca.marcaId());
    }

    @MutationMapping
    public Producto addProducto(@Argument ProductoInput productoInput) {
        return Producto.addProducto(productoInput);
    }

}
