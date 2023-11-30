package edu.fbansept.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.ecommerce.view.ProductOfferView;
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
    @JsonView({ProductView.class,ProductOfferView.class})
    private Integer sellerId;

    @Id
    @JsonView({ProductView.class,ProductOfferView.class})
    private Integer productId;

    @JsonView({ProductView.class,ProductOfferView.class})
    private float price;

    @JsonView({ProductView.class,ProductOfferView.class})
    private int quantity;

    @JsonView({ProductView.class,ProductOfferView.class})
    private int discount;

    @JsonView({ProductView.class,ProductOfferView.class})
    private boolean percentDiscount;

    @JsonView({ProductView.class,ProductOfferView.class})
    private String discountCode;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @JsonView(ProductOfferView.class)
    private Product product;

    @ManyToOne
    @MapsId("sellerId")
    @JoinColumn(name = "seller_id")
    @JsonView({ProductView.class,ProductOfferView.class})
    private Seller seller;
}
