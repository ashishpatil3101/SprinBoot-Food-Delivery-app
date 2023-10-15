package com.example.FoodDeliveryApp.dto.request;


import com.example.FoodDeliveryApp.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMenuItemRequest {

    int restaurantId;

    String dishName;

    FoodCategory foodCategory;

    int price;

    boolean available;

    boolean veg;
}
