package com.store.productcatalogue.Cart.Exception;

 

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 


public class DataNotFound extends Exception {

    public DataNotFound(String message) {
        super(message); // Pass message to the Exception class
    }



}