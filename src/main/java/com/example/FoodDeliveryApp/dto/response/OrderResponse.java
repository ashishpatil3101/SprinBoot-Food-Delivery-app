package com.example.FoodDeliveryApp.dto.response;

import com.example.FoodDeliveryApp.models.Customer;
import com.example.FoodDeliveryApp.models.DeliveryPartner;
import com.example.FoodDeliveryApp.models.FoodItem;
import com.example.FoodDeliveryApp.models.Restaurant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    String orderId;

    Date orderDate;
    int orderTotal;

    String deliveryPartnerName;

    String deliveryPartnerMob;

    String customerName;

    String customerMob;

    String restaurantName;

    List<FoodResponse> foodResponseList;
}
