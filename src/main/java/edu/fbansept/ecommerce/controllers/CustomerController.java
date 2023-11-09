package edu.fbansept.ecommerce.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.ecommerce.dao.CustomerDao;
import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.security.EcommerceUserDetails;
import edu.fbansept.ecommerce.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.JoinColumn;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/customer/all")
    @JsonView(UserView.class)
    public List<Customer> findAll(@AuthenticationPrincipal EcommerceUserDetails userDetails) {


        return customerDao.findAll();

    }

}
