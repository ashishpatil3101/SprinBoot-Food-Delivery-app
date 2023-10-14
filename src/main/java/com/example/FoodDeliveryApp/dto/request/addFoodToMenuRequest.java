package com.example.FoodDeliveryApp.dto.request;


import com.example.FoodDeliveryApp.Enum.FoodCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class addFoodToMenuRequest {

    int restaurantId;

    String dishName;

    FoodCategory foodCategory;

    int price;

    boolean available;

    boolean veg;
}
