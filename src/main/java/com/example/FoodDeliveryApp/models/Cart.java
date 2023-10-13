package com.example.FoodDeliveryApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int cartTotal;


    @OneToOne
    @JoinColumn
    Customer customer;


    @OneToMany( mappedBy = "cart", cascade = CascadeType.ALL)
    List<FoodItem> foodItems =  new ArrayList<>();


}
