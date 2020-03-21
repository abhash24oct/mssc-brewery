package abhash.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import abhash.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.beerName("Duvel")
				.beerStyle("IPA")
				.build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {

		return BeerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		
		
		log.debug("Upadating beerdto "+beerDto);
		return beerDto;
	}

	@Override
	public void deleteBeer(UUID beerId) {
		log.debug("Deleting beer with id "+beerId);
		
	}
	
	

}
