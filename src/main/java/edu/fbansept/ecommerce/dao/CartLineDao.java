package edu.fbansept.ecommerce.dao;

import edu.fbansept.ecommerce.models.CartLine;
import edu.fbansept.ecommerce.models.CartLineKey;
import edu.fbansept.ecommerce.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartLineDao extends JpaRepository<CartLine, CartLineKey> {

    List<CartLine> findAllByCustomer(Customer customer);

    Optional<CartLine> findByCustomerIdAndProductIdAndSellerId(
            int customerId, int productId, int sellerId);

    @Transactional
    void deleteByCustomer(Customer customer);
}