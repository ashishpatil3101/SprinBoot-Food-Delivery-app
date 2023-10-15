package com.example.FoodDeliveryApp.dto.response;

import com.example.FoodDeliveryApp.Enum.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantResponse {

    String name;

    String location;

    RestaurantCategory restaurantCategory;

    String contactNumber;

    List<MenuResponse> menu;
}
