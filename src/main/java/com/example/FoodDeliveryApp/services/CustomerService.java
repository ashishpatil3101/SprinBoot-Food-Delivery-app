package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.dto.request.CustomerRequest;
import com.example.FoodDeliveryApp.dto.response.CustomerResponse;
import com.example.FoodDeliveryApp.models.Cart;
import com.example.FoodDeliveryApp.models.Customer;
import com.example.FoodDeliveryApp.repositories.CustomerRepository;
import com.example.FoodDeliveryApp.transformers.CustomerTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public CustomerResponse createCustomer(CustomerRequest customerRequest){

        Customer customerObject = CustomerTransformers.CustomerRequestToCustomer( customerRequest );


        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customerObject);
        customerObject.setCart(cart);


        Customer customer = customerRepository.save( customerObject );
//        cart.setCustomer(customer);

        CustomerResponse  response = CustomerTransformers.CustomerToCustomerResponse( customer );
        response.setMessage("customer created successfully");
        return response;
    }

    public CustomerResponse updateCustomer(int customerId, CustomerRequest customerRequest) throws Exception {

        try {

            Optional<Customer> customer = customerRepository.findById( customerId );

            if( customer.isEmpty() )throw  new Exception("no customer with such id exist");

            if( customerRequest.getEmail() !=null) customer.get().setEmail(customerRequest.getEmail());

            if( customerRequest.getName() !=null ) customer.get().setName(customerRequest.getName());
            if( customerRequest.getMobNo() !=null) customer.get().setMobNo(customerRequest.getMobNo());
            customerRepository.save( customer.get() );

            CustomerResponse customerResponse=  CustomerTransformers.CustomerToCustomerResponse(customer.get());
            customerResponse.setMessage("customer updated succesfully");

            return customerResponse;
        }
        catch (Exception e ){
            System.out.println(e);
          throw  new Exception("request failed");
        }

    }

    public void deleteCustomer(int customerId) throws Exception {


        try{
            customerRepository.deleteById( customerId );
        }
        catch (Exception e){
            throw new Exception("customer deletion failed");
        }

    }

    public CustomerResponse getCustomer(int customerId) throws Exception {

        try {

            Optional<Customer> customer = customerRepository.findById( customerId );



            if( customer.isEmpty() )throw  new Exception("no customer with such id exist");
            System.out.println(customer.get().getName() + " "+customer.isEmpty() );

            CustomerResponse customerResponse = CustomerTransformers.CustomerToCustomerResponse(customer.get());
            customerResponse.setMessage("Customer info fetched sucessfully");
            System.out.println(customerResponse);

            return  customerResponse;
        }
        catch (Exception e ){
            System.out.println(e);
            throw  new Exception("request failed");
        }

    }
}
