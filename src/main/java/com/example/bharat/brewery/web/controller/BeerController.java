package com.example.bharat.brewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bharat.brewery.web.model.BeerDto;
import com.example.bharat.brewery.web.service.BeerService;

@RequestMapping(path = "/api/v1/beer")
@RestController
public class BeerController {


	private final BeerService service;
	
	
	public BeerController(@Qualifier(value = "Service1") BeerService service) {
		super();
		this.service = service;
	}


	@GetMapping(path = "/{Id}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable(name = "Id") UUID beerId)
	{
	return new ResponseEntity<BeerDto>(service.getBeer(beerId), HttpStatus.OK); 
	}
	
	
	@PostMapping(path = "")
	public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beer)
	{
		BeerDto newBeer = service.saveBeer(beer);
		HttpHeaders header = new HttpHeaders();
		header.add("Location", "http://localhost:8080/api/v1/beer/" +newBeer.getId().toString());
		return new ResponseEntity<BeerDto>(header, HttpStatus.CREATED); 
	}
	
	@PutMapping(path = "/{beerId}")
	public ResponseEntity handlePut(@PathVariable UUID beerId,BeerDto beer)
	{
		
		service.updateBeer(beerId,beer);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(path = "/{beerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable UUID beerId)
	{
		service.deleteBeer(beerId);
		//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
