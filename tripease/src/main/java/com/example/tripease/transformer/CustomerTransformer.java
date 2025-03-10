package com.example.tripease.transformer;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;

public class CustomerTransformer {
    //creating Transformer/Convertor
        public static Customer customerRequestToCustomer(CustomerRequest customerRequest){

//        Customer customer=new Customer();
//        customer.setName(customerRequest.getName());// we will get name from user so using customerrequest
//        customer.setAge(customerRequest.getAge());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setGender(customerRequest.getGender());

        //another way of creating an object using builer
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();

    }
    public static CustomerResponse customerToCustomerResponse(Customer customer){
//        CustomerResponse customerResponse=new CustomerResponse();
//
//        customerResponse.setName(customer.getName());
//        customerResponse.setAge(customer.getAge());
//        customerResponse.setEmailId(customer.getEmailId());

        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .emailId(customer.getEmailId())
                .build();

    }
}
