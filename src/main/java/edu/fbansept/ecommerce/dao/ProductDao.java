package edu.fbansept.ecommerce.dao;

import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}
