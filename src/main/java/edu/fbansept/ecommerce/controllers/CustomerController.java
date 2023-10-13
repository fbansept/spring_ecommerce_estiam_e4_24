package edu.fbansept.ecommerce.controllers;

import edu.fbansept.ecommerce.dao.CustomerDao;
import edu.fbansept.ecommerce.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

}
