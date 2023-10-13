package edu.fbansept.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "meta_data_product_type",
            joinColumns = @JoinColumn(name = "product_type_id"),
            inverseJoinColumns = @JoinColumn(name = "meta_data_id"))
    private Set<MetaData> metaDataList = new HashSet<>();

}
