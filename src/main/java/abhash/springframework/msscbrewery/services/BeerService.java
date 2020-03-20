package abhash.springframework.msscbrewery.services;

import java.util.UUID;

import abhash.springframework.msscbrewery.web.model.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

	void deleteBeer(UUID beerId);

}
