package com.example.bharat.brewery.web.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.bharat.brewery.web.model.BeerDto;
import com.example.bharat.brewery.web.model.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier(value = "Service1")
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeer(UUID id) {
		// TODO Auto-generated method stub
		return BeerDto.builder().beerName("KingFisherUltra")
				.id(UUID.randomUUID()).beerStyle(BeerStyleEnum.ALE).build();
	}

	@Override
	public BeerDto saveBeer(BeerDto beer) {
		
		BeerDto newBeer = BeerDto.builder().beerName(beer.getBeerName())
				.beerStyle(beer.getBeerStyle())
				.id(UUID.randomUUID())
				.upc(new Random().nextLong())
				.build();
		return newBeer;
		
	}

	@Override
	
	public void updateBeer(UUID id,BeerDto beer) {
		//todo
		
	}

	@Override
	public void deleteBeer(UUID id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
