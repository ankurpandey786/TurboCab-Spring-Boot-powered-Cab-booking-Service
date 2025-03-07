package com.example.tripease.model;

import com.example.tripease.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor//default constructor
@AllArgsConstructor//All argument contructor
@Getter
@Setter
@Entity
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;

    @Column(unique = true,nullable = false)
    private String emailId;

    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private List<Booking> bookings = new ArrayList<>();


}
