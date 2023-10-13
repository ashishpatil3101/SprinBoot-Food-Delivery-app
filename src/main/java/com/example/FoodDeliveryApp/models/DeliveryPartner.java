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
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;


    @Email
    @Column(unique = true)
    String email;

    @Column(nullable = false)
    int mobNo;

    @Enumerated( EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "deliveryPartner" , cascade =  CascadeType.ALL )
    List<OrderEntity> orders= new ArrayList<>();
}
