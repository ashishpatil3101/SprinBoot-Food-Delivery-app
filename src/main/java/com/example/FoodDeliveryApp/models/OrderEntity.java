package com.example.FoodDeliveryApp.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @Column(nullable = false)
    String orderId;

    @CreationTimestamp
    Date orderDate;


    int orderTotal;


    @ManyToOne
    @JoinColumn
    DeliveryPartner deliveryPartner;


    @ManyToOne
    @JoinColumn
    Customer customer;


    @ManyToOne
    @JoinColumn
    Restaurant restaurant;


}
