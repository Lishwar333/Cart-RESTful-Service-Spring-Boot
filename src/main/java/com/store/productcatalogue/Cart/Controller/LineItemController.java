package com.store.productcatalogue.Cart.Controller;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.store.productcatalogue.Cart.Exception.DataNotFound;
import com.store.productcatalogue.Cart.Exception.InvalidInput;
import com.store.productcatalogue.Cart.Model.Cart;
import com.store.productcatalogue.Cart.Model.LineItem;
import com.store.productcatalogue.Cart.Service.LineItemService;

 

@RequestMapping("/lineitem")
@RestController

 

public class LineItemController {

 

    @Autowired
    LineItemService lineitemservice;

 

    @GetMapping("/{id}")
    public LineItem searchLineItemById(@PathVariable int id) throws DataNotFound, InvalidInput {
        LineItem founditem = null;
        if (id < 1) {
            throw new InvalidInput("Invalid Input");
        } else {
            founditem = lineitemservice.searchLineItemById(id);
        }
        return founditem;
    }

 

    @PostMapping("/add/{id}")
    public LineItem createitem(@RequestBody LineItem item, @PathVariable int id) throws InvalidInput, DataNotFound {
        if (id < 1) {
            throw new InvalidInput("Invalid Input");
        } else {
            return lineitemservice.createitem(item, id);
        }
    }

 

    @PutMapping("/update/{id}")
    public LineItem updateitem(@RequestBody LineItem item, @PathVariable int id) throws InvalidInput, DataNotFound {
        if (id < 1) {
            throw new InvalidInput("Invalid Input");
        } else {
            return lineitemservice.updateitem(item, id);
        }
    }

 

    @DeleteMapping("/{id}")
    public void deleteLineItemById(@PathVariable int id) throws DataNotFound, InvalidInput {
        LineItem founditem = null;
        if (id < 1) {
            throw new InvalidInput("Invalid Input");
        } else {
            lineitemservice.deleteLineItemById(id);
        }
    }

 

}