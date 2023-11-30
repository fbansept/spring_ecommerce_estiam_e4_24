package edu.fbansept.ecommerce.dao;

import edu.fbansept.ecommerce.models.Product;
import edu.fbansept.ecommerce.models.ProductOffer;
import edu.fbansept.ecommerce.models.ProductOfferKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductOfferDao extends JpaRepository<ProductOffer, ProductOfferKey> {



}
