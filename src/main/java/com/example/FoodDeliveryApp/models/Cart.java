package com.example.FoodDeliveryApp.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "cart")
    List<FoodItem> foodItems = new ArrayList<>();


}
