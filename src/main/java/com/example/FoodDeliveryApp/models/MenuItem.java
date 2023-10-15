package com.example.FoodDeliveryApp.models;


import com.example.FoodDeliveryApp.Enum.FoodCategory;
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
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String dishName;
    @Enumerated(EnumType.STRING)
    FoodCategory foodCategory;

   int price;

   boolean available;

   boolean veg;

   @ManyToOne
   @JoinColumn
   Restaurant restaurant;

   @OneToMany(mappedBy = "menuItem",cascade = CascadeType.ALL)
   List<FoodItem>  foodItemList = new ArrayList<>();


}
