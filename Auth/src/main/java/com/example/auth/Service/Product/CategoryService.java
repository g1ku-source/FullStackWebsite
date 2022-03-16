package com.example.auth.Service.Product;

import com.example.auth.Model.Product.Category;

import java.util.List;

public interface CategoryService {

    Category getCategory(String name);
    Category addCategory(String name);
    List<Category> findAll();
}
