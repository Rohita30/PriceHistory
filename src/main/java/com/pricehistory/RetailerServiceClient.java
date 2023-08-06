package com.pricehistory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "retailer-service")
public interface RetailerServiceClient { 
	
	@GetMapping("/retailer/getRetailer/{retailerId}")
	ResponseEntity<?> getRetailerById(@PathVariable("retailerId") Long retailerId);

}
