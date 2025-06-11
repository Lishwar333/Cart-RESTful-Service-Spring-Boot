package com.store.productcatalogue.Cart;

 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

 

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cart Restful Web Service", version = "v1", description = "Cart Restful Web Service documentation"))
public class CartApplication {

 

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CartApplication.class, args);
    }

 

}