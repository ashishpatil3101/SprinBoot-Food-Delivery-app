package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.request.addFoodToMenuRequest;
import com.example.FoodDeliveryApp.dto.response.FoodResponse;
import com.example.FoodDeliveryApp.models.FoodItem;

public class FoodTransformer {

    public static FoodResponse foofItemToFoodResponse(FoodItem foodItem ){

        return  FoodResponse.builder()
                .price(foodItem.getPrice())
                .name(foodItem.getDishName())
                .build();
    }
    public static FoodItem foodItemRequestToFoodItem(addFoodToMenuRequest addfoodTomenuRequest ){

       return FoodItem.builder()
               .price(addfoodTomenuRequest.getPrice())
               .dishName(addfoodTomenuRequest.getDishName())
               .foodCategory(addfoodTomenuRequest.getFoodCategory())
               .veg(addfoodTomenuRequest.isVeg())
               .available(addfoodTomenuRequest.isAvailable())
               .build();
    }
}
