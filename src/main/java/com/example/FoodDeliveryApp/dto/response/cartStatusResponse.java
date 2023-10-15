package com.example.FoodDeliveryApp.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class cartStatusResponse {
    String customerName;
    String customerMobNo;

    String customerAddress;

    List<FoodResponse> foodList;

    int cartTotal;
}
