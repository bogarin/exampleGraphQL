package com.graphql.ejemplo.graphqljava.inputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoInput {
    private String name;
    private String prices;
    private String marcaId;
}
