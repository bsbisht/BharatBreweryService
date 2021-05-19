package com.example.bharat.brewery.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//Comment
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

	private UUID id;
	private Integer version;
	private OffsetDateTime createDt;
	private OffsetDateTime lastModifiedDt;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;
	private BigDecimal price;
	private Integer quantityOnHand;
	
}
