package com.store.productcatalogue.Cart.Model;

import javax.persistence.Entity;

import javax.persistence.Id;

 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Entity
public class LineItem {
    @Id
    int itemId;
    int productId;
    String productName;
    int quantity;
    double price;
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public LineItem(int itemId, int productId, String productName, int quantity, double price) {
        super();
        this.itemId = itemId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public LineItem() {
        super();
        // TODO Auto-generated constructor stub
    }


 

}