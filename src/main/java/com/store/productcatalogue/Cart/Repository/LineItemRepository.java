package com.store.productcatalogue.Cart.Repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

import com.store.productcatalogue.Cart.Model.LineItem;

 

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Integer> {

 

}