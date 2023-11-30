package edu.fbansept.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.ecommerce.view.ProductView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Admin extends User{


}