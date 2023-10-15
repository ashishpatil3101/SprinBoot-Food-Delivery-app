package com.example.FoodDeliveryApp.Controllers;

import com.example.FoodDeliveryApp.dto.request.FoodRequest;
import com.example.FoodDeliveryApp.dto.response.cartStatusResponse;
import com.example.FoodDeliveryApp.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    CartService cartService;

    @Autowired
    public CartController( CartService cartService ){
        this.cartService=cartService;
    }
    @PutMapping("/addFood")
    public ResponseEntity addFoodItemTocart(@RequestBody FoodRequest foodRequest){


        try {
            cartStatusResponse result =  cartService.addFoodItemTocart(foodRequest);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e ){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

    }

}
