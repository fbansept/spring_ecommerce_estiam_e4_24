package edu.fbansept.ecommerce.controllers;


import edu.fbansept.ecommerce.dao.CustomerDao;
import edu.fbansept.ecommerce.dao.ProductDao;
import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productDao.findAll();
    }

}