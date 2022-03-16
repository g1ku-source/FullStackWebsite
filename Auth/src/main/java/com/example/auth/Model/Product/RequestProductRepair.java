package com.example.auth.Model.Product;

import lombok.Getter;

@Getter
public class RequestProductRepair extends RequestProduct {

    private final String productName;

    public RequestProductRepair(String name, String description, Double price, String product) {
        super(name, description, price);
        this.productName = product;
    }
}
