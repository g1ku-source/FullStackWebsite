package com.example.auth.Model.Product;

import lombok.Getter;

@Getter
public class RequestProductObject extends RequestProduct {

    private Category category;
    private final Integer stock;

    public RequestProductObject(String name, String description, Double price, Integer stock) {

        super(name, description, price);
        this.stock = stock;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
