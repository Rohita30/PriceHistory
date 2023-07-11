package com.pricehistory.Dto;

import java.util.Date;

public class PriceHistoryDto { 
	
	private Long productId;
	
	private Long retailerId;
	
	private Float priceHistoryPrice;
	

	public PriceHistoryDto(Long productId, Long retailerId, Float priceHistoryPrice) {
		super();
		this.productId = productId;
		this.retailerId = retailerId;
		this.priceHistoryPrice = priceHistoryPrice;

	}

	public PriceHistoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Long retailerId) {
		this.retailerId = retailerId;
	}

	public Float getPriceHistoryPrice() {
		return priceHistoryPrice;
	}

	public void setPriceHistoryPrice(Float priceHistoryPrice) {
		this.priceHistoryPrice = priceHistoryPrice;
	}

}
