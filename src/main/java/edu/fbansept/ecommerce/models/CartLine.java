package edu.fbansept.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@IdClass(CartLineKey.class)
public class CartLine {

    @Id
    private Integer customerId;

    @Id
    private Integer productOfferId;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("productOfferId")
    @JoinColumn(name = "product_offer_id")
    private ProductOffer productOffer;

    private int quantity;
}
