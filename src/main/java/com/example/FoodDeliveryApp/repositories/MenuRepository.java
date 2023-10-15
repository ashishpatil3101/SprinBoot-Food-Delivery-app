package com.example.FoodDeliveryApp.repositories;

import com.example.FoodDeliveryApp.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem,Integer> {
}
