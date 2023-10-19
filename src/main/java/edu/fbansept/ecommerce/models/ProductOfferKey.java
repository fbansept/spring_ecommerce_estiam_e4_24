package edu.fbansept.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProductOfferKey implements Serializable {

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "product_id")
    private Integer productId;
}
