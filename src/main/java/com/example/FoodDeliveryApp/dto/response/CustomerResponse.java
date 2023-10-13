package com.example.FoodDeliveryApp.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

    String name;

    String email;

    String mobNo;

    String Message;

    CartResponse cart;
}
