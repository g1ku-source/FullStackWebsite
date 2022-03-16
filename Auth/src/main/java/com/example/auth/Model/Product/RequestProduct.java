package com.example.auth.Model.Product;

import lombok.Getter;

@Getter
public class RequestProduct {

    private final String name;
    private final String description;
    private final Double price;

    public RequestProduct(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
