package com.example.tripease.dto.request;

import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {
    private String pickUp;
    private String destination;
    private double tripDistanceInKm;
}
