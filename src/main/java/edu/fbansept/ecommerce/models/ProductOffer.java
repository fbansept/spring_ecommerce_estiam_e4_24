package edu.fbansept.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.ecommerce.view.ProductView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@IdClass(ProductOfferKey.class)
public class ProductOffer {

    @Id
    @JsonView(ProductView.class)
    private Integer sellerId;

    @Id
    @JsonView(ProductView.class)
    private Integer productId;

    @JsonView(ProductView.class)
    private float price;

    private int quantity;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("sellerId")
    @JoinColumn(name = "seller_id")
    @JsonView(ProductView.class)
    private Seller seller;
}
