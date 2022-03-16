package com.example.auth.Service.Product;

import com.example.auth.Model.Product.*;
import org.springframework.stereotype.Service;

@Service
public class ProductFactory implements BaseProductFactory {

    public ProductFactory() {}

    @Override
    public Product createProduct(String type, RequestProduct requestProduct) {

        return switch (type.toLowerCase()) {
            case "object" -> new ProductObject((RequestProductObject) requestProduct);
            case "repair" -> new ProductRepair((RequestProductRepair) requestProduct);
            default -> throw new IllegalArgumentException("No such object");
        };
    }
}
