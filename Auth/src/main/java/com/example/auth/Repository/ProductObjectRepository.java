package com.example.auth.Repository;

import com.example.auth.Model.Product.ProductObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductObjectRepository extends ProductRepository<ProductObject> {

    ProductObject findByName(String name);
    List<ProductObject> findByCategoryId(Long category_id);
}
