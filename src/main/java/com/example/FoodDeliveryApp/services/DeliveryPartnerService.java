package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.dto.request.DeliveryPartnerRequest;
import com.example.FoodDeliveryApp.dto.response.DeliveryPartnerResponse;
import com.example.FoodDeliveryApp.models.DeliveryPartner;
import com.example.FoodDeliveryApp.repositories.DeliveryPartnerRepository;
import com.example.FoodDeliveryApp.transformers.DeliveryPartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPartnerService {

    DeliveryPartnerRepository deliveryPartnerRepository;

    @Autowired
    public DeliveryPartnerService( DeliveryPartnerRepository deliveryPartnerRepository){
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    public DeliveryPartnerResponse createDeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest ){

        DeliveryPartner deliveryPartner = DeliveryPartnerTransformer.prepareDeliveryPartner( deliveryPartnerRequest);

        deliveryPartnerRepository.save(deliveryPartner);

        return DeliveryPartnerTransformer.prepareDeliveryPartnerResponse(deliveryPartner);
    }


}
