package com.example.tripease.dto.response;


import lombok.*;

@NoArgsConstructor//default constructor
@AllArgsConstructor//All argument contructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private String name;
    private int age;
    private String emailId;
}
