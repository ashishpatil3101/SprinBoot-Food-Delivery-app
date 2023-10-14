package com.example.FoodDeliveryApp.Controllers;


import com.example.FoodDeliveryApp.dto.request.RestaurantRequest;
import com.example.FoodDeliveryApp.dto.request.addFoodToMenuRequest;
import com.example.FoodDeliveryApp.dto.response.FoodResponse;
import com.example.FoodDeliveryApp.dto.response.RestaurantResponse;
import com.example.FoodDeliveryApp.models.Restaurant;
import com.example.FoodDeliveryApp.services.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService ){
        this.restaurantService = restaurantService;
    }

    @PostMapping("/add")
    public ResponseEntity addRestauRant(@RequestBody RestaurantRequest restaurantRequest ){

        try {

            RestaurantResponse restaurantResponse = restaurantService.addRestaurant( restaurantRequest );

            return new ResponseEntity( restaurantResponse, HttpStatus.CREATED );
        }
        catch (Exception e){
            return new ResponseEntity<>( "not able to create the restaurant" , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/status/{RestaurantId}")
    public ResponseEntity ChangeRestaurantOpenStatus(@PathVariable int RestaurantId){


        try{

             String restaurant = restaurantService.ChangeRestaurantOpenStatus( RestaurantId);

            return  new ResponseEntity(restaurant, HttpStatus.OK );

        }
        catch (Exception e ){
            return new ResponseEntity<>("not able to change the status", HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/update/{restaurantId}")
    public ResponseEntity updateRestaurant( @RequestBody RestaurantRequest restaurantRequest ,@PathVariable int restaurantId){

        try{

            String result = restaurantService.updateRestaurant( restaurantRequest , restaurantId);

            return new ResponseEntity( result, HttpStatus.OK);
        }
        catch (Exception e ){
            return new ResponseEntity<>(e , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity getRestaurant(@PathVariable int restaurantId){

        try{

            RestaurantResponse result = restaurantService.getRestaurant(  restaurantId);

            return new ResponseEntity( result, HttpStatus.OK);
        }
        catch (Exception e ){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{restaurantId}")
    public ResponseEntity deleteRestaurant(@PathVariable int restaurantId){

        try{

            String result = restaurantService.deleteRestaurant(  restaurantId);

            return new ResponseEntity( result, HttpStatus.OK);
        }
        catch (Exception e ){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/food/add")
    public ResponseEntity addFoodToMenu(@RequestBody addFoodToMenuRequest addFoodToMenuRequest){

        try{

            RestaurantResponse  restaurantResponse= restaurantService.addFoodTomenu(addFoodToMenuRequest);
            return new ResponseEntity<>( restaurantResponse ,HttpStatus.CREATED );
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/food/veg")
    public  ResponseEntity getAllVegORNonVegFoodItems(@RequestParam("id")int restaurantId,@RequestParam("veg")boolean veg){

        try{
            List<FoodResponse> foodResponseList = restaurantService.getAllVegFoodItems(restaurantId , veg);

            return new ResponseEntity<>( foodResponseList, HttpStatus.OK );
        }
        catch (Exception e ){

            return new ResponseEntity<>( e.getMessage(), HttpStatus.OK );
        }
    }
}
