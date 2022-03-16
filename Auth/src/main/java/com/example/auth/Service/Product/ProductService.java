package com.example.auth.Service.Product;

import com.example.auth.Model.AppUser.AppUser;
import com.example.auth.Model.Product.Product;
import com.example.auth.Model.Product.ProductObject;
import com.example.auth.Model.Product.ProductRepair;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    Product getProduct(String name);
    List<ProductObject> getAllByCategory(String name);
    List<ProductObject> getAll();
    List<ProductRepair> getAllByUser(AppUser appUser);
}
