package com.example.FoodDeliveryApp.models;


import com.example.FoodDeliveryApp.Enum.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodItem {

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

   @ManyToOne
   @JoinColumn
   Cart cart;

   @ManyToOne
    @JoinColumn
    OrderEntity orderEntity;
}
