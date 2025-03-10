package com.example.tripease.dto.request;

import com.example.tripease.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor//default constructor
@AllArgsConstructor//All argument contructor
@Getter
@Setter
public class CustomerRequest {
    private String name;
    private int age;
    private String emailId;

    private Gender gender;
}
