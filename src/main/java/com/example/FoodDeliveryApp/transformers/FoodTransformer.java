package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.response.FoodResponse;
import com.example.FoodDeliveryApp.models.FoodItem;

public class FoodTransformer {

    public static FoodResponse foofItemToFoodResponse(FoodItem foodItem ){

        return  FoodResponse.builder()
                .price(foodItem.getPrice())
                .name(foodItem.getDishName())
                .build();
    }
}
