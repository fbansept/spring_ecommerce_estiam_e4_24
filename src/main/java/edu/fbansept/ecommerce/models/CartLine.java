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
    private Integer productId;

    @Id
    private Integer sellerId;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "product_id", insertable=false, updatable=false),
            @JoinColumn(name = "seller_id", insertable=false, updatable=false)}
    )
    private ProductOffer productOffer;

    private int quantity;
}
