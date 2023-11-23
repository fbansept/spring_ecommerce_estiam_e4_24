package edu.fbansept.ecommerce.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.ecommerce.dao.CustomerDao;
import edu.fbansept.ecommerce.dao.ProductDao;
import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.models.Product;
import edu.fbansept.ecommerce.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/products")
    @JsonView(ProductView.class)
    public List<Product> findAll() {
        return productDao.findAll();
    }

}