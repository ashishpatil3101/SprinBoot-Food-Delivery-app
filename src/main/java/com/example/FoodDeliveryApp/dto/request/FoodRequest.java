package com.example.FoodDeliveryApp.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodRequest {

    int totalQuantity;

    String customerEmail;

    int menuItemId;
}
