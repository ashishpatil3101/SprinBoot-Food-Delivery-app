package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.request.AddMenuItemRequest;
import com.example.FoodDeliveryApp.dto.response.MenuResponse;
import com.example.FoodDeliveryApp.models.FoodItem;
import com.example.FoodDeliveryApp.models.MenuItem;

public class MenuItemTransformer {

    public static MenuResponse foofItemToFoodResponse(MenuItem foodItem){

        return  MenuResponse.builder()
                .price(foodItem.getPrice())
                .name(foodItem.getDishName())
                .build();
    }
    public static MenuItem foodItemRequestToFoodItem(AddMenuItemRequest addfoodTomenuItemRequest){

       return MenuItem.builder()
               .price(addfoodTomenuItemRequest.getPrice())
               .dishName(addfoodTomenuItemRequest.getDishName())
               .foodCategory(addfoodTomenuItemRequest.getFoodCategory())
               .veg(addfoodTomenuItemRequest.isVeg())
               .available(addfoodTomenuItemRequest.isAvailable())
               .build();
    }
}
