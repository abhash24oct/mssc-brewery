package abhash.springframework.msscbrewery.services;

import java.util.UUID;


import abhash.springframework.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);

}
