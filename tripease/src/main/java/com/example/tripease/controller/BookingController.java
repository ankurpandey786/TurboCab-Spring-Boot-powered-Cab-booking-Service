package com.example.tripease.controller;

import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/book/customer/{customer-id}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @PathVariable("customer-id") int customerId){
        return bookingService.bookCabService(bookingRequest,customerId);

    }

}
