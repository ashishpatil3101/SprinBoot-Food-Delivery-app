package com.example.FoodDeliveryApp.dto.response;

import com.example.FoodDeliveryApp.models.FoodItem;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponse {

    int cartTotal;

    List<FoodItem> foodItems;
}
