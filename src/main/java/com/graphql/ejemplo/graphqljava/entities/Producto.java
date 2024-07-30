package com.graphql.ejemplo.graphqljava.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.graphql.ejemplo.graphqljava.inputs.ProductoInput;

public record Producto(String id, String name, String prices, String marcaId) {

    private static final List<Producto> productos = new ArrayList<>(Arrays.asList(
            new Producto("producto-1", "MacBook pro 14", "$60,000.00", "marca-1"),
            new Producto("producto-2", "Lenovo ThinkPad 14", "$20,000.00", "marca-2"),
            new Producto("producto-3", "Huawei MateBook X Pro", "$40,000.00", "marca-3")));

    public static Producto getByIProducto(String id) {
        return productos.stream()
                .filter(producto -> producto.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static Producto addProducto(ProductoInput productoInput) {
        final Producto producto = new Producto("producto-" + productos.size(),
                productoInput.getName(), productoInput.getPrices(), productoInput.getMarcaId());
        productos.add(producto);
        return producto;
    }

    public static List<Producto> getAllProducto() {
        return productos;
    }

    public static List<Producto> getProductoByIdMarca(String idMarca) {
        return productos.stream().filter(producto -> producto.marcaId().equals(idMarca)).toList();
    }

}
