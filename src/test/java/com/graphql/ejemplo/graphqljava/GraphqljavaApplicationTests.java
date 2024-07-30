package com.graphql.ejemplo.graphqljava;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.graphql.ejemplo.graphqljava.controllers.ProductoController;
import com.graphql.ejemplo.graphqljava.entities.Producto;

@GraphQlTest(ProductoController.class)
class GraphqljavaApplicationTests {

	@Autowired
	private GraphQlTester graphQlTester;

	@Test
	void testQueryProducto() {
		String query = """
						query{
									getAllProductos{
				  					name
				  					prices
									}
						}
				""";
		graphQlTester.document(query)
				.execute()
				.path("getAllProductos")
				.entityList(Producto.class)
				.satisfies(productos -> {
					assertThat(productos).hasSize(3);
					assertThat(productos).extracting("name")
                            .contains("MacBook pro 14","Lenovo ThinkPad 14","Huawei MateBook X Pro");
							assertThat(productos).extracting("prices")
                            .contains("$60,000.00","$20,000.00","$40,000.00");
				});
	}

}
