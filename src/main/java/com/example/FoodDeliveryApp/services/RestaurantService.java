package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.dto.request.RestaurantRequest;
import com.example.FoodDeliveryApp.dto.response.RestaurantResponse;
import com.example.FoodDeliveryApp.models.Restaurant;
import com.example.FoodDeliveryApp.repositories.RestaurantRepository;
import com.example.FoodDeliveryApp.transformers.RestaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService( RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) throws Exception {

        try{
            Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant( restaurantRequest );

            restaurantRepository.save(restaurant ) ;
            RestaurantResponse restaurantResponse = RestaurantTransformer.restaurantToRestaurantResponse( restaurant );

            return restaurantResponse;
        }
        catch (Exception e){
            throw new Exception("not able to create restaurant");
        }
    }

    public String ChangeRestaurantOpenStatus( int RestaurantId){


        try{

            Optional<Restaurant> restaurant = restaurantRepository.findById( RestaurantId);
            if( restaurant.isEmpty()) throw new Exception("no restaurant exist with such id");

            restaurant.get().setOpen(!restaurant.get().isOpen());

            restaurantRepository.save( restaurant.get() );
            return  "successfully  changed the status of restaurant.isOpen "+restaurant.get().isOpen();

        }
        catch (Exception e ){
            throw new Error("not able change the status of restaurant");
        }
    }

    public String updateRestaurant( RestaurantRequest restaurantRequest,int RestaurantId ) throws Exception {

        try{

            Optional<Restaurant> restaurant = restaurantRepository.findById( RestaurantId );

            if(restaurant.isEmpty()) throw new Exception("not restaurant with such id exist");

            if( restaurantRequest.getLocation() != null) restaurant.get().setLocation( restaurantRequest.getLocation());
            if( restaurantRequest.getName() != null )restaurant.get().setName(restaurantRequest.getName());
            if( restaurantRequest.getContactNumber() != null) restaurant.get().setContactNumber(restaurantRequest.getContactNumber());

            restaurantRepository.save( restaurant.get() );

            return "succesfully updated the resturant information";

        }
        catch (Exception e ){
            throw new Exception("not able to update the restaurant");
        }
    }

    public RestaurantResponse getRestaurant( int restaurantId) throws Exception{

        try{

            Optional<Restaurant> restaurant = restaurantRepository.findById( restaurantId );

            if( restaurant.isEmpty() ) throw new Exception("no restaurant with such id exist");

            return RestaurantTransformer.restaurantToRestaurantResponse( restaurant.get() );

        }
        catch( Exception e){
            throw new Exception("unable to fetch the restaurant");
        }
    }

    public String deleteRestaurant( int restaurantId) throws Exception{

        try{

            Optional<Restaurant> restaurant = restaurantRepository.findById( restaurantId );

            if( restaurant.isEmpty() ) throw new Exception("no restaurant with such id exist");

            restaurantRepository.delete(restaurant.get() );

            return "succesfully deleted the resturant";

        }
        catch( Exception e){
            throw new Exception("unable to delete the restaurant");
        }
    }
}