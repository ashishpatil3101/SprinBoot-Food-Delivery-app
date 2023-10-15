package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.response.FoodResponse;
import com.example.FoodDeliveryApp.dto.response.OrderResponse;
import com.example.FoodDeliveryApp.models.Cart;
import com.example.FoodDeliveryApp.models.FoodItem;
import com.example.FoodDeliveryApp.models.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransformer {

    public static OrderEntity prepareOrderEntity(Cart cart){

        return OrderEntity.builder()
                .orderId(String.valueOf(UUID.randomUUID()))
                .orderTotal(cart.getCartTotal())
                .build();
    }

    public static OrderResponse prepareOrderResponse(OrderEntity savedOrderEntity) {

        List<FoodResponse> foodList =new ArrayList<>();
        for(FoodItem foodItem : savedOrderEntity.getFoodItemList()){
            FoodResponse foodResponse = FoodTransformer.foodItemToFOodResponse( foodItem) ;
            foodResponse.setQuantity( foodItem.getRequiredQuantity());

            foodList.add(foodResponse);
        }

        return OrderResponse.builder()
                .orderId(savedOrderEntity.getOrderId())
                .orderTotal(savedOrderEntity.getOrderTotal())
                .orderDate(savedOrderEntity.getOrderDate())
                .customerMob(savedOrderEntity.getCustomer().getMobNo())
                .customerName(savedOrderEntity.getCustomer().getName())
                .deliveryPartnerName(savedOrderEntity.getDeliveryPartner().getName())
                .deliveryPartnerMob(savedOrderEntity.getDeliveryPartner().getMobNo())
                .restaurantName(savedOrderEntity.getRestaurant().getName())
                .foodResponseList(foodList)
                .build();
    }
}
