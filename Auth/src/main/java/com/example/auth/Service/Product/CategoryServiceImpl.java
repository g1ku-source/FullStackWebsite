package com.example.auth.Service.Product;

import com.example.auth.Model.Product.Category;
import com.example.auth.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategory(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category addCategory(String name) {
        return categoryRepository.save(new Category(name));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
