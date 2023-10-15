package com.example.FoodDeliveryApp.dto.request;

import com.example.FoodDeliveryApp.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryPartnerRequest {

    String name;

    String email;


    String mobNo;

    Gender gender;
}
