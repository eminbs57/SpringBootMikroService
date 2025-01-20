package com.example.siparis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/

@Entity
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siparisid;
    private Long menuId;  
    private int quantity;
    private Double totalPrice;

    // Getters and Setters
    public Long getId() {
        return siparisid;
    }

    public void setId(Long id) {
        this.siparisid = id;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

/*
 * // "menuId":1, 
 * "quantity" : 2, 
 * "totalPrice" : 30
 */