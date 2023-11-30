package edu.fbansept.ecommerce.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.ecommerce.dao.CustomerDao;
import edu.fbansept.ecommerce.dao.ProductDao;
import edu.fbansept.ecommerce.dao.ProductOfferDao;
import edu.fbansept.ecommerce.models.Customer;
import edu.fbansept.ecommerce.models.Product;
import edu.fbansept.ecommerce.models.ProductOffer;
import edu.fbansept.ecommerce.view.ProductView;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;
    private ProductOfferDao productOfferDao;

    @GetMapping("/products")
    @JsonView(ProductView.class)
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        System.out.println(product.getName());

        return null;
    }

    @JsonView(ProductView.class)
    @DeleteMapping("/admin/product/{idProduct}")
    public ResponseEntity<Product> deleteProduct(
            @PathVariable int idProduct) {

        Optional<Product> productOptional = productDao.findById(idProduct);

        //Si l'offre existe
        if(productOptional.isPresent()) {
            productDao.deleteById(idProduct);
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/seller/product-offer/{id}")
    public ResponseEntity<ProductOffer> deleteProduct(
            @PathVariable int idProductOffer,
            @AuthenticationPrincipal UserDetails userDetails) {

        Optional<ProductOffer> productOfferOptional = productOfferDao.findById(idProductOffer);

        //Si l'offre existe
        if(productOfferOptional.isPresent()) {
            //Si le vendeur du produit est le même que l'utilisateur connecté
            if(productOfferOptional.get().getSeller().getEmail().equals(userDetails.getUsername())) {
                productOfferDao.deleteById(idProductOffer);
                return new ResponseEntity<>(productOfferOptional.get(), HttpStatus.OK);
            }

            return new ResponseEntity<>(productOfferOptional.get(), HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}