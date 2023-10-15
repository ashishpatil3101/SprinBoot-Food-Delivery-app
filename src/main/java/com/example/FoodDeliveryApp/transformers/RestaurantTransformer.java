package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.request.RestaurantRequest;
import com.example.FoodDeliveryApp.dto.response.MenuResponse;
import com.example.FoodDeliveryApp.dto.response.RestaurantResponse;
import com.example.FoodDeliveryApp.models.MenuItem;
import com.example.FoodDeliveryApp.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTransformer {

    public static RestaurantResponse restaurantToRestaurantResponse(Restaurant restaurant){

        List<MenuResponse> menu = new ArrayList<>();

        for(MenuItem menuItem : restaurant.getMenuItems()){

            MenuResponse FItem = MenuItemTransformer.foofItemToFoodResponse(menuItem);
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
                .menuItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }


}
