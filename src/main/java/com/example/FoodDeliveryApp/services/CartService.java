package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.dto.request.FoodRequest;
import com.example.FoodDeliveryApp.dto.response.cartStatusResponse;
import com.example.FoodDeliveryApp.models.Customer;
import com.example.FoodDeliveryApp.models.FoodItem;
import com.example.FoodDeliveryApp.models.MenuItem;
import com.example.FoodDeliveryApp.repositories.CustomerRepository;
import com.example.FoodDeliveryApp.repositories.FoodRepository;
import com.example.FoodDeliveryApp.repositories.MenuRepository;
import com.example.FoodDeliveryApp.transformers.CartTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    final CustomerRepository customerRepository;
    final MenuRepository menuRepository;
    final FoodRepository foodRepository;

    @Autowired
    public CartService(CustomerRepository customerRepository, MenuRepository menuRepository, FoodRepository foodRepository){
        this.menuRepository=menuRepository;
        this.customerRepository=customerRepository;

        this.foodRepository = foodRepository;
    }

    public cartStatusResponse addFoodItemTocart(FoodRequest foodRequest) throws Exception {

        Customer optionalCustomer = customerRepository.findByEmail(foodRequest.getCustomerEmail());
        if(optionalCustomer == null) {
            throw new Exception("no customer with such id exist");
        }
        Optional<MenuItem> optionalMenuItem = menuRepository.findById(foodRequest.getMenuItemId());
        if(optionalMenuItem.isEmpty())  throw new Exception("no menuItem with such id exist");

        MenuItem menuItem =optionalMenuItem.get();

        if( !menuItem.isAvailable() )throw new Exception("food item currently out of stocks");

        //prepare for foodItem
        FoodItem foodItem = FoodItem.builder()
                .cart(optionalCustomer.getCart())
                .menuItem(menuItem)
                .totalCost(foodRequest.getTotalQuantity() * menuItem.getPrice() )
                .requiredQuantity( foodRequest.getTotalQuantity())
                .build();

        //save the foodItem db
        FoodItem savedFoodItem  = foodRepository.save( foodItem );

        menuItem.getFoodItemList().add(savedFoodItem);
        //add to cart
        optionalCustomer.getCart().getFoodItems().add(savedFoodItem);
        optionalCustomer.getCart().setCartTotal(optionalCustomer.getCart().getCartTotal()+savedFoodItem.getTotalCost());

        //save customer
        customerRepository.save( optionalCustomer);

        cartStatusResponse  cartStatusResponse = CartTransformer.PreparecartStatusResponse( optionalCustomer ,foodRequest.getTotalQuantity());

        return cartStatusResponse;

    }
}
