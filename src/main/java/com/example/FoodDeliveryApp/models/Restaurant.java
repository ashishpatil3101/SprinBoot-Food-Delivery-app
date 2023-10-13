package com.example.FoodDeliveryApp.models;


import com.example.FoodDeliveryApp.Enum.RestaurantCategory;
import jakarta.annotation.Nullable;
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
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String  name;

    @Column(nullable = false)
    String location;

    @Enumerated(EnumType.STRING)
    RestaurantCategory restaurantCategory;

    boolean open;

    String contactNumber;

    @OneToMany(mappedBy = "restaurant",cascade =  CascadeType.ALL )
    List<FoodItem> foodItems = new ArrayList<>();

    @OneToMany( mappedBy = "restaurant" , cascade =  CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();


}
