package com.store.productcatalogue.Cart.Repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

import com.store.productcatalogue.Cart.Model.Cart;

 

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {



 

}