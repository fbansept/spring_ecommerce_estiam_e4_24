package edu.fbansept.ecommerce.dao;

import edu.fbansept.ecommerce.models.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductOrderDao extends JpaRepository<ProductOrder, Integer> {



}
