package com.example.tripease.model;

import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Booking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookingId;
    String pickUp;
    String destination;
    double tripDistanceInKm;

    @Enumerated(value = EnumType.STRING)
    TripStatus tripStatus;

    double billAmount;

    @CreationTimestamp
    Date bookedAt;

    @UpdateTimestamp
    Date lastUpdateAt;

}
