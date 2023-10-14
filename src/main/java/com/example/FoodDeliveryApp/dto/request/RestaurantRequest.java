package com.example.FoodDeliveryApp.dto.request;

import com.example.FoodDeliveryApp.Enum.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantRequest {

    String name;

    String location;

    RestaurantCategory restaurantCategory;

    String contactNumber;
}
