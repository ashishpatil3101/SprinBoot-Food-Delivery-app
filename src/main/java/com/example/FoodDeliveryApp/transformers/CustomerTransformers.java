package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.request.CustomerRequest;
import com.example.FoodDeliveryApp.dto.response.CartResponse;
import com.example.FoodDeliveryApp.dto.response.CustomerResponse;
import com.example.FoodDeliveryApp.dto.response.MenuResponse;
import com.example.FoodDeliveryApp.models.Customer;
import com.example.FoodDeliveryApp.models.FoodItem;
import com.example.FoodDeliveryApp.models.MenuItem;

public class CustomerTransformers {

    public static CustomerResponse CustomerToCustomerResponse(Customer customer){

        CartResponse cart = CartTransformer.cartToCartResponse( customer.getCart() );

        for(FoodItem foodItem : customer.getCart().getFoodItems() ){

//            MenuResponse menuResponse = MenuItemTransformer.foofItemToFoodResponse(menuItem);
            cart.getFoodItems().add(foodItem);
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
