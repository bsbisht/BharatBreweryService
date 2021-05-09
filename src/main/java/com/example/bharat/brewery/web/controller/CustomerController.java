package com.example.bharat.brewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bharat.brewery.web.model.BeerDto;
import com.example.bharat.brewery.web.model.CustomerDto;
import com.example.bharat.brewery.web.service.CustomerService;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

@Autowired	
private CustomerService service;
	
@RequestMapping(path = "/{customerId}")

public ResponseEntity<CustomerDto> getCustomerByID(@PathVariable(name = "customerId") UUID id)
{
	System.out.println(id);
	return new ResponseEntity<CustomerDto>(service.getCustomerById(id), HttpStatus.OK);
}


@PostMapping(path = "")
public ResponseEntity<CustomerDto> handlePost(@RequestBody CustomerDto customer)
{
	CustomerDto newCustomer = service.saveCustomer(customer);
	HttpHeaders header = new HttpHeaders();
	header.add("Location", "http://localhost:8080/api/v1/customer/" +newCustomer.getId().toString());
	return new ResponseEntity<CustomerDto>(header, HttpStatus.CREATED); 
}

@PutMapping(path = "/{customerId}")
public ResponseEntity handlePut(@PathVariable UUID customerId,CustomerDto customer)
{
	service.updateCustomer(customerId,customer);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@DeleteMapping(path = "/{customerId}")
@ResponseStatus(code = HttpStatus.NO_CONTENT)
public void handleDelete(@PathVariable UUID customerId)
{
	service.deleteCustomer(customerId);
	//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}






}
