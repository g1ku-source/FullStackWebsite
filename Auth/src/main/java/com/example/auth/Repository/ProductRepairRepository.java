package com.example.auth.Repository;

import com.example.auth.Model.AppUser.AppUser;
import com.example.auth.Model.Product.ProductRepair;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepairRepository extends ProductRepository<ProductRepair>{

    List<ProductRepair> findByAppUser(AppUser appUser);
}
