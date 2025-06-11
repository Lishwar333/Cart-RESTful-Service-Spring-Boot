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
import com.store.productcatalogue.Cart.Service.CartService;

 

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/{id}")
    public Cart searchCartById(@PathVariable int id) throws DataNotFound, InvalidInput
    {
        Cart foundcart=null;
        if(id<1)
        {
            throw new InvalidInput("Invalid Input");
        }
        else
        {
            foundcart=cartService.serachCartById(id);
        }
        return foundcart;
    }

        @PostMapping("/addcart")
        public Cart addCartById(@RequestBody Cart cart) throws InvalidInput {
        	
        	
            return cartService.addCartById(cart);


    }

        @PutMapping("/update")
        public Cart updateCartById(@RequestBody Cart cart) throws InvalidInput, DataNotFound {
            return cartService.updateCartById(cart);

}
        @DeleteMapping("/{id}")
        public Cart deleteCartById(@PathVariable int id) throws DataNotFound, InvalidInput
        {
            Cart foundcart=null;
            if(id<1)
            {
                throw new InvalidInput("Invalid Input");
            }
            else
            {
                foundcart=cartService.deleteCartById(id);
            }
            return foundcart;
}        
}