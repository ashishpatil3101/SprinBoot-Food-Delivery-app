package com.example.FoodDeliveryApp.repositories;

import com.example.FoodDeliveryApp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findByEmail(String email);
    public Customer findByMobNo(String  mobNo);
}
