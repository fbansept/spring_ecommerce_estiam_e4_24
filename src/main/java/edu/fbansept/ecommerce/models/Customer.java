package edu.fbansept.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Customer extends User{

    private String code;



}
