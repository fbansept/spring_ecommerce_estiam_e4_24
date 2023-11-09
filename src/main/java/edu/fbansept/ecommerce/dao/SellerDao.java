package edu.fbansept.ecommerce.dao;

import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDao extends JpaRepository<Seller, Integer> {
}
