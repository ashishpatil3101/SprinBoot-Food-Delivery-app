package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.request.RestaurantRequest;
import com.example.FoodDeliveryApp.dto.response.FoodResponse;
import com.example.FoodDeliveryApp.dto.response.RestaurantResponse;
import com.example.FoodDeliveryApp.models.FoodItem;
import com.example.FoodDeliveryApp.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTransformer {

    public static RestaurantResponse restaurantToRestaurantResponse(Restaurant restaurant){

        List<FoodResponse> menu = new ArrayList<>();

        for(FoodItem foodItem : restaurant.getFoodItems()){

            FoodResponse FItem = FoodTransformer.foofItemToFoodResponse(foodItem);
            menu.add( FItem );

        }

        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .contactNumber(restaurant.getContactNumber())
                .restaurantCategory(restaurant.getRestaurantCategory())
                .menu( menu)
                .build();
    }

    public static Restaurant RestaurantRequestToRestaurant(RestaurantRequest restaurantRequest){

        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .location(restaurantRequest.getLocation())
                .contactNumber(restaurantRequest.getContactNumber())
                .restaurantCategory(restaurantRequest.getRestaurantCategory())
                .open(true)
                .foodItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }


}
