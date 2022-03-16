package com.example.auth.Service.Product;

import com.example.auth.Model.AppUser.AppUser;
import com.example.auth.Model.Product.Category;
import com.example.auth.Model.Product.Product;
import com.example.auth.Model.Product.ProductObject;
import com.example.auth.Model.Product.ProductRepair;
import com.example.auth.Repository.CategoryRepository;
import com.example.auth.Repository.ProductObjectRepository;
import com.example.auth.Repository.ProductRepairRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductObjectRepository productObjectProductRepository;
    private final ProductRepairRepository productRepairProductRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product saveProduct(Product product) {

        if(product instanceof ProductObject) {
            ProductObject productObject = productObjectProductRepository.findByName(product.getName());
            if(productObject == null)
                return productObjectProductRepository.save((ProductObject) product);

            productObject.setStock(productObject.getStock() + ((ProductObject) product).getStock());
            return productObjectProductRepository.save(productObject);
        }
        if(product instanceof ProductRepair)
            return productRepairProductRepository.save((ProductRepair) product);

        return null;
    }

    @Override
    public Product getProduct(String name) {
        return null;
    }

    @Override
    public List<ProductObject> getAllByCategory(String name) {

        Category category = categoryRepository.findByName(name);
        if (category == null)
            return null;
        return productObjectProductRepository.findByCategoryId(category.getId());
    }

    @Override
    public List<ProductObject> getAll() {
        return productObjectProductRepository.findAll();
    }

    @Override
    public List<ProductRepair> getAllByUser(AppUser appUser) {
        return productRepairProductRepository.findByAppUser(appUser);
    }
}
