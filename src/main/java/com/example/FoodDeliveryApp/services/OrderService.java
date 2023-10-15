package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.dto.response.OrderResponse;
import com.example.FoodDeliveryApp.models.*;
import com.example.FoodDeliveryApp.repositories.CustomerRepository;
import com.example.FoodDeliveryApp.repositories.DeliveryPartnerRepository;
import com.example.FoodDeliveryApp.repositories.OrderRepository;
import com.example.FoodDeliveryApp.repositories.RestaurantRepository;
import com.example.FoodDeliveryApp.transformers.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    OrderRepository orderRepository;
    CustomerRepository customerRepository;

     DeliveryPartnerRepository deliveryPartnerRepository;

     RestaurantRepository restaurantRepository;

    @Autowired
    public OrderService( OrderRepository orderRepository,
                         CustomerRepository customerRepository,
                         DeliveryPartnerRepository deliveryPartnerRepository,
                         RestaurantRepository restaurantRepository
    ){
        this.orderRepository=orderRepository;
        this.customerRepository=customerRepository;
        this.deliveryPartnerRepository=deliveryPartnerRepository;
        this.restaurantRepository=restaurantRepository;
    }

    public OrderResponse placeOrder(String customerMobNo) throws Exception {

        Customer customer = customerRepository.findByMobNo(customerMobNo);
        if( customer == null )throw new Exception("no customer with such id exist");

        //check cart if it is valid or not
        Cart cart = customer.getCart();
        if( cart.getFoodItems().size() == 0)throw new Exception("can not place order on empty cart");

        //findDelivery partner randomly
        DeliveryPartner deliveryPartner = deliveryPartnerRepository.findRandomDeliveryPartner();

        Restaurant restaurant = cart.getFoodItems().get(0).getMenuItem().getRestaurant();
        //prepre an order
        OrderEntity orderEntity = OrderTransformer.prepareOrderEntity( customer.getCart() );



        //save orderEntity
        OrderEntity savedOrderEntity = orderRepository.save( orderEntity );

        orderEntity.setCustomer(customer);
        orderEntity.setDeliveryPartner(deliveryPartner);
        orderEntity.setRestaurant(cart.getFoodItems().get(0).getMenuItem().getRestaurant());
        orderEntity.setFoodItemList(cart.getFoodItems());

        customer.getOrderEntity().add( savedOrderEntity );
        deliveryPartner.getOrders().add(savedOrderEntity);
        cart.getFoodItems().get(0).getMenuItem().getRestaurant().getOrders().add(savedOrderEntity);

        //chnages in foodItem table
        for(FoodItem foodItem: cart.getFoodItems()){
            foodItem.setOrder(savedOrderEntity);
            foodItem.setCart(null);
        }

        //clear the cart
        clearCart(cart);

        //save
        customerRepository.save(customer);
        deliveryPartnerRepository.save( deliveryPartner );
        restaurantRepository.save(restaurant);

        return OrderTransformer.prepareOrderResponse( savedOrderEntity );
    }

    public void clearCart(Cart cart ){
        cart.setCartTotal(0);
        cart.setFoodItems(new ArrayList<>());
    }


}
