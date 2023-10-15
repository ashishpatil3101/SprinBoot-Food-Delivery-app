package com.example.FoodDeliveryApp.repositories;

import com.example.FoodDeliveryApp.models.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner,Integer> {

    String findRandomPartner = "select dp from DeliveryPartner dp order by RAND() LIMIT 1";

    @Query(value =findRandomPartner )
    public DeliveryPartner findRandomDeliveryPartner();


}
