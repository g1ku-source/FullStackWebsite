package com.example.auth.Model.Product;

import com.example.auth.Model.AppUser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class ProductRepair extends Product {

    private String product;

    @ManyToOne
    private AppUser appUser;

    public ProductRepair(String name, String description, Double price, String product) {
        super(name, description, price);
        this.product = product;
    }

    public ProductRepair(RequestProductRepair requestProductRepair) {
        super(requestProductRepair.getName(),
                requestProductRepair.getDescription(),
                requestProductRepair.getPrice());
        this.product = requestProductRepair.getProductName();
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
