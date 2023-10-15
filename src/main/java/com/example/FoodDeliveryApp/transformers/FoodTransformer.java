package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.response.FoodResponse;
import com.example.FoodDeliveryApp.models.FoodItem;
import com.example.FoodDeliveryApp.models.MenuItem;

public class FoodTransformer {

    public static FoodResponse foodItemToFOodResponse(FoodItem foodItem){

        return FoodResponse.builder()
                .veg(foodItem.getMenuItem().isVeg())
                .dishName(foodItem.getMenuItem().getDishName())
                .price(foodItem.getMenuItem().getPrice())
                .build();
    }
}
