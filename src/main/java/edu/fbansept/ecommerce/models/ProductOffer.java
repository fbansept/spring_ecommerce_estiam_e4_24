package edu.fbansept.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@IdClass(ProductOfferKey.class)
public class ProductOffer {

    @Id
    private Integer sellerId;

    @Id
    private Integer productId;

    private float price;

    private int quantity;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("sellerId")
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
