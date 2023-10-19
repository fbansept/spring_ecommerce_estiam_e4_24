package edu.fbansept.ecommerce.dao;

import edu.fbansept.ecommerce.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineDao extends JpaRepository<OrderLine, Integer> {


}