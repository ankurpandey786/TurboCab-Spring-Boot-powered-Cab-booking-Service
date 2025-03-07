package com.example.tripease.service;

import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomerService(CustomerRequest customerRequest) {

        //RequestDTOs to entity Conversion
        //customer repo will not understand customerRequest because it taken parameter of Cutomer
        //so we need to do DTOs(customerRequest) to entity(Customer) conversion

        //converting.......already made a class of transformer/conversion in transformer pakage
        //just calling it here..
        Customer customer= CustomerTransformer.customerRequestToCustomer(customerRequest);


        //save entity to DB
        Customer savedCustomer=customerRepository.save(customer);//automatically it will add query in your database


        //Entity to DTO conversion
        //save entity -> Response DTOs
        //using transformer here
        return CustomerTransformer.customerToCustomerResponse(customer);

    }

    public CustomerResponse getCustomerService(int customerId) {

        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);//find id with this pk and syntax in db

        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");//if customer is not present
        }

        Customer savedCustomer=optionalCustomer.get();

        //Entity to DTO conversion
        //save entity -> Response DTOs
        //using transformer here
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);

    }

    public List<CustomerResponse> getAllByGenderService(Gender gender) {
        List<Customer> customers=customerRepository.findByGender(gender);

        //entity -> response dtos
        List<CustomerResponse> customerResponses=new ArrayList<>();

        for(Customer customer:customers){
             customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAgeService(Gender gender, int age) {
        List<Customer> customers=customerRepository.findByGenderAndAge(gender,age);

        //entity -> response dtos
        List<CustomerResponse> customerResponses=new ArrayList<>();

        for(Customer customer:customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers=customerRepository.getAllByGenderAndAgeGreaterThan(gender,age);

        //entity -> response dtos
        List<CustomerResponse> customerResponses=new ArrayList<>();

        for(Customer customer:customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
