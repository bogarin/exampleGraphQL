package com.graphql.ejemplo.graphqljava.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.graphql.ejemplo.graphqljava.inputs.MarcaInput;

public record Marca(String marcaId, String name) {

    private static final List<Marca> marcas = new ArrayList<>(Arrays.asList(
            new Marca("marca-1", "Apple"),
            new Marca("marca-2", "Lenovo"),
            new Marca("marca-3", "Huawei")));

    public static Marca getByIdMarca(String id) {
        return marcas.stream()
                .filter(marca -> marca.marcaId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static Marca add(MarcaInput marcaInput) {
        final Marca marca = new Marca("marca-" + marcas.size(),
                marcaInput.getName());
        marcas.add(marca);
        return marca;
    }
    

}
