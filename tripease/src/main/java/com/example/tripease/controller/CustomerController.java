package com.example.tripease.controller;

import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;
import com.example.tripease.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomerService(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customer_id){
        return customerService.getCustomerService(customer_id);
    }

    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable("gender") Gender gender){
        return customerService.getAllByGenderService(gender);
    }


    //api of all the people of particuler gender and age,ex- all male of age 25
    @GetMapping("/get")
    public List<CustomerResponse> getAllByGenderAndAge(@RequestParam("gender") Gender gender,
                                                       @RequestParam("age") int age){
        return customerService.getAllByGenderAndAgeService(gender,age);
    }

    //get all the people of the particular gender and whose age > input age
    @GetMapping("/get-by-age-greater-than")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@RequestParam("gender") Gender gender,
                                                       @RequestParam("age") int age){
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }
}
