package com.example.auth.Service.Product;

import com.example.auth.Model.Product.Product;
import com.example.auth.Model.Product.RequestProduct;

public interface BaseProductFactory {

    Product createProduct(String type, RequestProduct requestProduct);
}
