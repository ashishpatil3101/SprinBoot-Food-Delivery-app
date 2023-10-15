package com.example.FoodDeliveryApp.transformers;

import com.example.FoodDeliveryApp.dto.request.DeliveryPartnerRequest;
import com.example.FoodDeliveryApp.dto.response.DeliveryPartnerResponse;
import com.example.FoodDeliveryApp.models.DeliveryPartner;

import java.util.ArrayList;

public class DeliveryPartnerTransformer {

    public static DeliveryPartnerResponse prepareDeliveryPartnerResponse(DeliveryPartner deliveryPartner){

        return  DeliveryPartnerResponse.builder()
                .mobNo(deliveryPartner.getMobNo())
                .name(deliveryPartner.getName())
                .email(deliveryPartner.getEmail())
                .build();
    }
    public static DeliveryPartner prepareDeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest){

        return DeliveryPartner.builder()
                .mobNo(deliveryPartnerRequest.getMobNo())
                .email(deliveryPartnerRequest.getEmail())
                .name(deliveryPartnerRequest.getName())
                .gender(deliveryPartnerRequest.getGender())
                .orders(new ArrayList<>())
                .build();
    }
}
