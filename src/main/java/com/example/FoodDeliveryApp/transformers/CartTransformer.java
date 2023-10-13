package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.response.CartResponse;
import com.example.FoodDeliveryApp.models.Cart;
import org.hibernate.type.internal.UserTypeSqlTypeAdapter;

import java.util.ArrayList;

public class CartTransformer {

    public static CartResponse cartToCartResponse(Cart cart){

        return CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();
    }
}
