package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.response.CartResponse;
import com.example.FoodDeliveryApp.dto.response.FoodResponse;
import com.example.FoodDeliveryApp.dto.response.cartStatusResponse;
import com.example.FoodDeliveryApp.models.Cart;
import com.example.FoodDeliveryApp.models.Customer;
import com.example.FoodDeliveryApp.models.FoodItem;
import org.hibernate.type.internal.UserTypeSqlTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResponse cartToCartResponse(Cart cart){

        return CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();
    }
    public static cartStatusResponse PreparecartStatusResponse(Customer customer, int quantity){
        List<FoodResponse> fooDlist = new ArrayList<>();

        for(FoodItem foodItem: customer.getCart().getFoodItems()){

            FoodResponse foodResponse = FoodTransformer.foodItemToFOodResponse( foodItem);
            foodResponse.setQuantity( quantity);
            fooDlist.add(foodResponse);
        }

        return cartStatusResponse.builder()
                .customerName(customer.getName())
                .customerMobNo(customer.getMobNo())
                .customerAddress(customer.getAddress())
                .foodList( fooDlist)
                .cartTotal(customer.getCart().getCartTotal())
                .build();
    }
}
