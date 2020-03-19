package abhash.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import abhash.springframework.msscbrewery.web.model.BeerDto;


@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.beerName("Duvel")
				.beerStyle("IPA")
				.build();
	}

}
