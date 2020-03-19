package abhash.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abhash.springframework.msscbrewery.web.model.CustomerDto;
import abhash.springframework.msscbrewery.services.CustomerService;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	private CustomerService customerService;
	
	public  CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID customerId) {
		return new ResponseEntity(customerService.getCustomerById(customerId),HttpStatus.OK);
	}

}
