package com.example.auth.Controller;

import com.example.auth.Model.AppUser.AppUser;
import com.example.auth.Model.Product.*;
import com.example.auth.Service.AppUser.AppUserService;
import com.example.auth.Service.Product.BaseProductFactory;
import com.example.auth.Service.Product.CategoryService;
import com.example.auth.Service.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final BaseProductFactory productFactory;
    private final AppUserService appUserService;
    private final CategoryService categoryService;

//    @PostMapping("/save")
//    public ResponseEntity<Product> saveProduct(@RequestBody RequestProduct requestProduct) {
//
//        Product product = null;
//
//        if(requestProduct instanceof RequestProductObject)
//            System.out.println("ds");
//            product = productService.saveProduct(
//                    productFactory.createProduct("object",
//                            requestProduct)
//            );
//        if(requestProduct instanceof RequestProductRepair)
//            product = productService.saveProduct(
//                    productFactory.createProduct("repair",
//                            requestProduct)
//            );
//
//        if(product == null)
//            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
//        return ResponseEntity.ok().body(product);
//    }

    @PostMapping("/save/object/{category}")
    public ResponseEntity<Product> saveProductObject(@RequestBody RequestProductObject requestProductObject,
                                                     @PathVariable String category) {

        Category categoryObject = categoryService.getCategory(category);

        if(categoryObject == null) {
            categoryObject = categoryService.addCategory(category);
        }

        requestProductObject.setCategory(categoryObject);

        Product product = productService.saveProduct(
                productFactory.createProduct("object", requestProductObject)
        );

        if(product == null)
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/save/repair/{username}")
    public ResponseEntity<Product> saveProductRepair(@RequestBody RequestProductRepair requestProductRepair,
                                                     @PathVariable String username) {

        ProductRepair productRepair = (ProductRepair) productFactory.createProduct("repair", requestProductRepair);

        AppUser appUser = appUserService.getUser(username);
        if(appUser == null)
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
        productRepair.setAppUser(appUser);

        Product product = productService.saveProduct(productRepair);

        if(product == null)
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
        return ResponseEntity.ok().body(productRepair);
    }

    @GetMapping("/get_product")
    public ResponseEntity<List<ProductObject>> getProductObjects() {

        List<ProductObject> productObjects = productService.getAll();

        if(productObjects == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok().body(productObjects);
    }

    @GetMapping("/get_product/{category}")
    public ResponseEntity<List<ProductObject>> getProductObjectByCategory(@PathVariable String category) {

        List<ProductObject> productObjects = productService.getAllByCategory(category);

        if(productObjects == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok().body(productObjects);
    }

    @GetMapping("/get_product/repair/{username}")
    public ResponseEntity<List<ProductRepair>> getProductRepairById(@PathVariable String username) {

        AppUser appUser = appUserService.getUser(username);
        if(appUser == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        List<ProductRepair> productRepairList = productService.getAllByUser(appUser);
        if(productRepairList == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok().body(productRepairList);
    }

    @GetMapping("/get_categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.findAll();

        if(categories == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok().body(categories);
    }
}
