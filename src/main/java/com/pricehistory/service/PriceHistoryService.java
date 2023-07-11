package com.pricehistory.service;

import java.util.List;

import com.pricehistory.Dto.PriceHistoryDto;
import com.pricehistory.Dto.PriceHistoryDto2;
import com.pricehistory.Dto.PriceHistoryUpdateDto;

public interface PriceHistoryService { 
	
	public String addPriceHistory(PriceHistoryDto priceHistoryDto);
	public PriceHistoryDto2 getPriceHistory(Long priceHistoryId);
	public List<PriceHistoryDto2> getAllPriceHistory();
	public String deletePriceHistory(Long priceHistoryId);
	public String updatePriceHistory(Long priceHistoryId, PriceHistoryUpdateDto ap2);

}
