package abhash.springframework.msscbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import abhash.springframework.msscbrewery.services.BeerService;
import abhash.springframework.msscbrewery.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

	private final BeerService beerService;
	
	
	public  BeerController(BeerService beerService) {
		this.beerService=beerService;
	}
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
		
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> handlePost(@Valid @RequestBody BeerDto beerDto){
		BeerDto saveDto = beerService.saveNewBeer(beerDto);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Location","/api/v1/beer/"+saveDto.getId().toString());
		return new ResponseEntity<>(header,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDto){
		
		@SuppressWarnings("unused")
		BeerDto updatebeer = beerService.updateBeer(beerId,beerDto);
		
		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteBeer(beerId);
	}
	
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<List<String>> validationErrorHandler(MethodArgumentNotValidException e){
		   List<String> errors = new ArrayList<String>(e.getBindingResult().getErrorCount());
		  
		    e.getBindingResult().getFieldErrors().forEach(e2 -> errors.add(e2.getField()+" "+e2.getDefaultMessage()+":: supplied value "+e2.getRejectedValue().toString())); 
		  
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
}
