package com.store.productcatalogue.Cart.Exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class InvalidInput extends Exception {


    public InvalidInput(String message) {
        super(message);
        
    }

 

}