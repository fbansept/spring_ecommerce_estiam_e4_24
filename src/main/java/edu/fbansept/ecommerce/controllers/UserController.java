package edu.fbansept.ecommerce.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.ecommerce.dao.CustomerDao;
import edu.fbansept.ecommerce.dao.UserDao;
import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.models.User;
import edu.fbansept.ecommerce.security.EcommerceUserDetails;
import edu.fbansept.ecommerce.security.JwtUtils;
import edu.fbansept.ecommerce.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword())
        );

        EcommerceUserDetails userDetails = (EcommerceUserDetails)authentication.getPrincipal();

        return "Bearer " + jwtUtils.generateJwt(userDetails);

    }

}
