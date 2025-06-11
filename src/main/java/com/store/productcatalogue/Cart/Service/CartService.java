package com.store.productcatalogue.Cart.Service;

 

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.store.productcatalogue.Cart.Exception.DataNotFound;
import com.store.productcatalogue.Cart.Exception.InvalidInput;
import com.store.productcatalogue.Cart.Model.Cart;
import com.store.productcatalogue.Cart.Model.LineItem;
import com.store.productcatalogue.Cart.Repository.CartRepository;

 

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

 

    public Cart serachCartById(int id) throws DataNotFound {
        Cart foundcart = null;
        Optional<Cart> foundcarts = cartRepository.findById(id);

 

        if (foundcarts.isPresent()) {
            foundcart = foundcarts.get();
        } else {
            throw new DataNotFound("No Cart with id: " + id);
        }
        return foundcart;
    }

    public Cart addCartById(Cart cart) throws InvalidInput {
        List<LineItem> items = cart.getLineitem();
        for (LineItem a : items) {
            if (a.getItemId() < 1 || a.getPrice() < 1 || a.getProductId() < 1 || a.getProductName() == null
                    || a.getQuantity() < 1) {
                throw new InvalidInput("Invalid Input");
            }
        }

 

        cartRepository.save(cart);
        return cart;
    }

 

    public Cart updateCartById(Cart cart) throws InvalidInput, DataNotFound {

        Optional<Cart>foundcart=cartRepository.findById(cart.getCartId());
        if(foundcart.isPresent()) {
        List<LineItem> items = cart.getLineitem();
        for (LineItem a : items) {
            if (a.getItemId() < 1 || a.getPrice() < 1 || a.getProductId() < 1 || a.getProductName() == null
                    || a.getQuantity() < 1) {
                throw new InvalidInput("Invalid Input");
            }
        }

 

        cartRepository.save(cart);
        return cart;
    }else {
        throw new DataNotFound("No Cart with id: "+cart.getCartId());
    }
    }
        public Cart deleteCartById(int id) throws DataNotFound {

            Optional<Cart> foundcarts = cartRepository.findById(id);

 

            if (foundcarts.isPresent()) {
                  return foundcarts.get();
            } else {
                throw new DataNotFound("No Cart with id: " + id);
            }

 

        }


}