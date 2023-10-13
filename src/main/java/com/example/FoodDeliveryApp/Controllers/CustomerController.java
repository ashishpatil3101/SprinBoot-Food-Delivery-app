package com.example.FoodDeliveryApp.Controllers;

import com.example.FoodDeliveryApp.dto.request.CustomerRequest;
import com.example.FoodDeliveryApp.dto.response.CustomerResponse;
import com.example.FoodDeliveryApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController( CustomerService customerService ){
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity createCustomer(@RequestBody CustomerRequest customerRequest ){

        CustomerResponse response = customerService.createCustomer( customerRequest );

        return new ResponseEntity( response, HttpStatus.CREATED );

    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable int customerId, @RequestBody CustomerRequest customerRequest ){

        try{
            System.out.println(customerId + " l");
            CustomerResponse response = customerService.updateCustomer( customerId , customerRequest );

            return new ResponseEntity( response, HttpStatus.OK );
        }
        catch (Exception e ){

            return new ResponseEntity<>("updation of customer failed" , HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("delete/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable int customerId){

        try{
            customerService.deleteCustomer( customerId  );

            return new ResponseEntity( "customer deleted succesfully", HttpStatus.OK );
        }
        catch (Exception e ){

            return new ResponseEntity<>("deletion of customer failed" , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{customerId}")
    public ResponseEntity getCustomer(@PathVariable int customerId){

        try{
            CustomerResponse response = customerService.getCustomer( customerId  );

            return new ResponseEntity( response, HttpStatus.OK );
        }
        catch (Exception e ){

            return new ResponseEntity<>("unable to fetch the customer" , HttpStatus.BAD_REQUEST);
        }

    }

}
