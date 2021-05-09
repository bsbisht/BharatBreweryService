package com.example.bharat.brewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.bharat.brewery.web.model.BeerDto;


public interface BeerService {

public BeerDto getBeer(UUID id);
public BeerDto saveBeer(BeerDto beer);
public void updateBeer(UUID id,BeerDto beer);
public void deleteBeer(UUID id);

	
}
