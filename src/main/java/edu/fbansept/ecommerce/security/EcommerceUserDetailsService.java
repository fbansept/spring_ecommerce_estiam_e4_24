package edu.fbansept.ecommerce.security;

import edu.fbansept.ecommerce.dao.CustomerDao;
import edu.fbansept.ecommerce.dao.SellerDao;
import edu.fbansept.ecommerce.dao.UserDao;
import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.models.Seller;
import edu.fbansept.ecommerce.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcommerceUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email inconnu"));

        boolean isCustomer = customerDao.existsById(user.getId());
        boolean isSeller = sellerDao.existsById(user.getId());

        return new EcommerceUserDetails(user, isCustomer, isSeller);
    }
}
