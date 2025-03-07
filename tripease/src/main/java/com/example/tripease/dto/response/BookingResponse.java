package com.example.tripease.dto.response;

import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    String pickUp;
    String destination;
    double tripDistanceInKm;

    TripStatus tripStatus;

    double billAmount;

    Date bookedAt;

    Date lastUpdateAt;

    CustomerResponse customer;

    CabResponse cab;


}
