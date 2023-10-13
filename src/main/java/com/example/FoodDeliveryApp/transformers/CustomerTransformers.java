package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.request.CustomerRequest;
import com.example.FoodDeliveryApp.dto.response.CartResponse;
import com.example.FoodDeliveryApp.dto.response.CustomerResponse;
import com.example.FoodDeliveryApp.dto.response.FoodResponse;
import com.example.FoodDeliveryApp.models.Customer;
import com.example.FoodDeliveryApp.models.FoodItem;

public class CustomerTransformers {

    public static CustomerResponse CustomerToCustomerResponse(Customer customer){

        CartResponse cart = CartTransformer.cartToCartResponse( customer.getCart() );

        for(FoodItem foodItem: customer.getCart().getFoodItems() ){

            FoodResponse foodResponse = FoodTransformer.foofItemToFoodResponse( foodItem );
            cart.getFoodItems().add(foodResponse);
        }
        System.out.println("cart");
        return CustomerResponse.builder()
                .mobNo(customer.getMobNo())
                .name(customer.getName())
                .email(customer.getEmail())
                .cart(cart)
                .build();
    }

    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest){

        return Customer.builder()
                .mobNo(customerRequest.getMobNo())
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .gender(customerRequest.getGender())
                .build();
    }

}
