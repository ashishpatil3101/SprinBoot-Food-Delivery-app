package com.example.FoodDeliveryApp.repositories;

import com.example.FoodDeliveryApp.models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodItem ,Integer> {

}
