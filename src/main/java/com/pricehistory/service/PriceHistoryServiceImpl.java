package com.pricehistory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricehistory.Dto.PriceHistoryDto;
import com.pricehistory.Dto.PriceHistoryDto2;
import com.pricehistory.Dto.PriceHistoryUpdateDto;
import com.pricehistory.entity.PriceHistory;
import com.pricehistory.entity.Product;
import com.pricehistory.entity.Retailer;
import com.pricehistory.repository.PriceHistoryRepository;
import com.pricehistory.repository.ProductRepository;
import com.pricehistory.repository.RetailerRepository;

@Service
public class PriceHistoryServiceImpl implements PriceHistoryService { 
	
	@Autowired
	private PriceHistoryRepository priceHistoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired 
	private RetailerRepository retailerRepo;
	
	@Override
	public String addPriceHistory(PriceHistoryDto pricehistorydto) {
    	Long productId=pricehistorydto.getProductId();
    	Long retailerId=pricehistorydto.getRetailerId();
    	PriceHistory app=new PriceHistory();
    	
//    	for product
    	Product product;
    	product = productRepo.findById(productId).get();
    	app.setProduct(product);
    	
    	
//    	for retailer
    	Retailer retailer;
    	retailer = retailerRepo.findById(retailerId).get();
    	app.setRetailer(retailer);
    			
//    	app.setPriceHistoryId(pricehistorydto.getPriceHistoryId());
    	app.setPriceHistoryPrice(pricehistorydto.getPriceHistoryPrice());
    	Date d = new Date();
        
    	app.setPriceHistoryDate(d);
    	
    	priceHistoryRepo.save(app);
    	
    	return "Price History Created";
	}
	
	@Override
	public PriceHistoryDto2 getPriceHistory(Long priceHistoryId) {
	        PriceHistory a =  priceHistoryRepo.findById(priceHistoryId).get();
	        PriceHistoryDto2 ap = new PriceHistoryDto2();
	        ap.setPriceHistoryDate(a.getPriceHistoryDate());
	        ap.setPriceHistoryId(a.getPriceHistoryId());
	        ap.setProductId(a.getProduct().getProductId());
	        ap.setRetailerId(a.getRetailer().getRetailerId());
	        ap.setPriceHistoryPrice(a.getPriceHistoryPrice());
	        return ap;
	    }

	@Override
	public List<PriceHistoryDto2> getAllPriceHistory() {
    	List <PriceHistory> priceHistoryList = priceHistoryRepo.findAll();
    	
    	List<PriceHistoryDto2> priceHistoryDtoList = new ArrayList<>();
    	
    	for(PriceHistory ap : priceHistoryList) {
    		PriceHistoryDto2 app2 = new PriceHistoryDto2();
    		app2.setPriceHistoryDate(ap.getPriceHistoryDate());
    		app2.setPriceHistoryId(ap.getPriceHistoryId());
    		app2.setPriceHistoryPrice(ap.getPriceHistoryPrice());
    		app2.setProductId(ap.getProduct().getProductId());
    		app2.setRetailerId(ap.getRetailer().getRetailerId());
    		
    		priceHistoryDtoList.add(app2);
    		
    	}
    	return priceHistoryDtoList;
    }

	@Override
	public String deletePriceHistory(Long priceHistoryId) {
		// TODO Auto-generated method stub
		priceHistoryRepo.deleteById(priceHistoryId);
		return "Price History Deleted Successfully";
	}

	@Override
	public String updatePriceHistory(Long priceHistoryId,
			PriceHistoryUpdateDto ap2) {
		// TODO Auto-generated method stub
		
		PriceHistory ap = priceHistoryRepo.findById(priceHistoryId).get();
		Date d = new Date();
		ap.setPriceHistoryDate(d);
		ap.setPriceHistoryPrice(ap2.getPriceHistoryPrice());

		priceHistoryRepo.save(ap);

		
		return "Price History Updated Succesfully.";
	}

}
