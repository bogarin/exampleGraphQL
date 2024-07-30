package com.graphql.ejemplo.graphqljava.dtos;

import java.util.List;

import com.graphql.ejemplo.graphqljava.entities.Marca;
import com.graphql.ejemplo.graphqljava.entities.Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MarcaProductoDTO {
    private Marca marca;
    private List<Producto> productos;
}
