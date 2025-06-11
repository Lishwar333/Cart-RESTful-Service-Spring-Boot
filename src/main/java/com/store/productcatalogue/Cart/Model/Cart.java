package com.store.productcatalogue.Cart.Model;

 

import java.util.List;

 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 


@Entity
public class Cart {

    @Id
    int cartId;


    @OneToMany(targetEntity=LineItem.class,cascade=CascadeType.ALL)
    @JoinColumn(name="fk",referencedColumnName="cartId")
    List<LineItem>lineitem;

 


    public int getCartId() {
        return cartId;
    }

 


    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

 


    public List<LineItem> getLineitem() {
        return lineitem;
    }

 


    public void setLineitem(List<LineItem> lineitem) {
        this.lineitem = lineitem;
    }

 


    public Cart(int cartId, List<LineItem> lineitem) {
        super();
        this.cartId = cartId;
        this.lineitem = lineitem;
    }

 


    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

 

    
}