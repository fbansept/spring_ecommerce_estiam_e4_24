package edu.fbansept.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.ecommerce.view.ProductOfferView;
import edu.fbansept.ecommerce.view.ProductView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProductView.class)
    private Integer id;

    @JsonView({ProductView.class,ProductOfferView.class})
    private String name;

    @JsonView({ProductView.class,ProductOfferView.class})
    private String description;

    @JsonView(ProductView.class)
    @OneToMany(mappedBy = "product")
    private List<ProductOffer> productOfferList;

}
