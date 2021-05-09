package com.example.bharat.brewery.web.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.bharat.brewery.web.model.BeerDto;
import com.example.bharat.brewery.web.model.CustomerDto;

@Service
public class CustomerImpl1 implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID id) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().id(UUID.randomUUID()).name("Bharat Bisht").build();
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto customer) {
		
		CustomerDto newCustomer = CustomerDto.builder().id(UUID.randomUUID())
				.name(customer.getName()).build();
		return newCustomer;
	}

	@Override
	public void updateCustomer(UUID id, CustomerDto customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
