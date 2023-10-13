package com.example.FoodDeliveryApp.models;

import com.example.FoodDeliveryApp.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Email
    @Column(unique = true)
    String email;


    String address;

    @Column(nullable = false)
    String mobNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy ="customer" , cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany( mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderEntity> orderEntity = new ArrayList<>();

}
