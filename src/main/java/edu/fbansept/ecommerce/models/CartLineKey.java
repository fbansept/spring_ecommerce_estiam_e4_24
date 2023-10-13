package edu.fbansept.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CartLineKey implements Serializable {

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "product_offer_id")
    private Integer productOfferId;
}
