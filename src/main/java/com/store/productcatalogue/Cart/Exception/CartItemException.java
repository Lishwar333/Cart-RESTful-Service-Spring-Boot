package com.store.productcatalogue.Cart.Exception;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CartItemException{

@ExceptionHandler(DataNotFound.class)

    public ResponseEntity<Object> handleDataNotFound(DataNotFound ex)
    {
        Map<String, Object> body=new LinkedHashMap<>();
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDate.now());
        return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
    }

 

@ExceptionHandler(InvalidInput.class)

public ResponseEntity<Object> handleInvalidInput(InvalidInput ex)
{
    Map<String, Object> body=new LinkedHashMap<String, Object>();
    body.put("message", ex.getMessage());
    body.put("timestamp", LocalDate.now());    
    return new ResponseEntity<Object>(body,HttpStatus.BAD_REQUEST);
}


}