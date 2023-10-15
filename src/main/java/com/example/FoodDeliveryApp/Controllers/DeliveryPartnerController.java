package com.example.FoodDeliveryApp.Controllers;

import com.example.FoodDeliveryApp.dto.request.DeliveryPartnerRequest;
import com.example.FoodDeliveryApp.dto.response.DeliveryPartnerResponse;
import com.example.FoodDeliveryApp.services.DeliveryPartnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliverypartner")
public class DeliveryPartnerController {

    final DeliveryPartnerService deliveryPartnerService;

    public DeliveryPartnerController( DeliveryPartnerService deliveryPartnerService){
        this.deliveryPartnerService=deliveryPartnerService;
    }

    @PostMapping("/add")
    public ResponseEntity createDeliveryPartner(@RequestBody DeliveryPartnerRequest deliveryPartnerRequest){

        try{
            DeliveryPartnerResponse deliveryPartnerResponse = deliveryPartnerService.createDeliveryPartner( deliveryPartnerRequest);

            return new ResponseEntity(deliveryPartnerResponse ,HttpStatus.CREATED );
        }
        catch (Exception e ){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_GATEWAY);
        }
    }
}
