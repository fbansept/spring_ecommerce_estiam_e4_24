package edu.fbansept.ecommerce.dao;

import edu.fbansept.ecommerce.models.CartLineKey;
import edu.fbansept.ecommerce.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartLineDao extends JpaRepository<Customer, CartLineKey> {
}