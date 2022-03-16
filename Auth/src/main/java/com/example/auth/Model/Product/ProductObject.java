package com.example.auth.Model.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class ProductObject extends Product {

    private Integer stock;

    @ManyToOne
    private Category category;

    public ProductObject(String name, String description, Double price, Category category, Integer stock) {
        super(name, description, price);
        this.category = category;
        this.stock = stock;
    }

    public ProductObject(RequestProductObject requestProductObject) {
        super(requestProductObject.getName(),
                requestProductObject.getDescription(),
                requestProductObject.getPrice());
        this.category = requestProductObject.getCategory();
        this.stock = requestProductObject.getStock();
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
