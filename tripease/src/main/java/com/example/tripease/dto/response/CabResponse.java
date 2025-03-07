package com.example.tripease.dto.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {
    private String cabNumber;
    private String cabModel;
    private double perKmRate;
    private boolean available;


    //driver response
    private DriverResponse driver;
}
