package edu.fbansept.ecommerce.dao;

import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
