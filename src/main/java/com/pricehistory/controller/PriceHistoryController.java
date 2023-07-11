package com.pricehistory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pricehistory.Dto.PriceHistoryDto;
import com.pricehistory.Dto.PriceHistoryDto2;
import com.pricehistory.Dto.PriceHistoryUpdateDto;
import com.pricehistory.service.PriceHistoryService;

@RestController
@RequestMapping("/pricehistory")
public class PriceHistoryController { 
	
	@Autowired
	private PriceHistoryService priceHistoryServ;
	
	@PostMapping("/addPriceHistory")
	public ResponseEntity<?> addPriceHistory(@RequestBody PriceHistoryDto priceHistoryDto) {
		return new ResponseEntity<String> (priceHistoryServ.addPriceHistory(priceHistoryDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getPriceHistory/{priceHistoryId}")
	@HystrixCommand(fallbackMethod = "fallback_getPriceHistory", commandProperties = {
	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public ResponseEntity<?> getPriceHistory(@PathVariable Long priceHistoryId){
		return new ResponseEntity<PriceHistoryDto2> (priceHistoryServ.getPriceHistory(priceHistoryId), HttpStatus.OK);
	}
	
	@GetMapping("/getPriceHistory")
	@HystrixCommand(fallbackMethod = "fallback_getAllPriceHistory", commandProperties = {
	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public ResponseEntity<?> getAllPriceHistory() {
		return new ResponseEntity<List<PriceHistoryDto2>> (priceHistoryServ.getAllPriceHistory(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePriceHistory/{priceHistoryId}")
	public ResponseEntity<?> deletePriceHistory(@PathVariable Long priceHistoryId) {
		return new ResponseEntity<String> (priceHistoryServ.deletePriceHistory(priceHistoryId), HttpStatus.OK);
	}
	
	@PutMapping("/updatePriceHistory/{priceHistoryId}")
	public ResponseEntity<?> update(@PathVariable Long priceHistoryId, @RequestBody PriceHistoryUpdateDto ap2) {
		priceHistoryServ.updatePriceHistory(priceHistoryId, ap2);
		return new ResponseEntity<String> (HttpStatus.OK);
	}
    
	private ResponseEntity<?> fallback_getPriceHistory(Long priceHistoryId) {
        // Fallback response when getPriceHistory fails
        return new ResponseEntity<String>("Unable to fetch price history. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private ResponseEntity<?> fallback_getAllPriceHistory() {
        // Fallback response when getAllPriceHistory fails
        return new ResponseEntity<String>("Unable to fetch all price history. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
