package com.example.bharat.brewery.web.service;

import java.util.UUID;

import com.example.bharat.brewery.web.model.CustomerDto;

public interface CustomerService {

public CustomerDto getCustomerById(UUID id);	
public CustomerDto saveCustomer(CustomerDto customer);
public void updateCustomer(UUID id,CustomerDto customer);
public void deleteCustomer(UUID id);

}
