package com.pricehistory.Dto;

import java.util.Date;

public class PriceHistoryDto2 {  
	
	private Long priceHistoryId;
	
	private Long productId;
	
	private Long retailerId;

	private Float priceHistoryPrice;

	private Date priceHistoryDate;

	public PriceHistoryDto2(Long priceHistoryId, Long productId, Long retailerId, Float priceHistoryPrice,
			Date priceHistoryDate) {
		super();
		this.priceHistoryId = priceHistoryId;
		this.productId = productId;
		this.retailerId = retailerId;
		this.priceHistoryPrice = priceHistoryPrice;
		this.priceHistoryDate = priceHistoryDate;
	}

	public PriceHistoryDto2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPriceHistoryId() {
		return priceHistoryId;
	}

	public void setPriceHistoryId(Long priceHistoryId) {
		this.priceHistoryId = priceHistoryId;
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

	public Date getPriceHistoryDate() {
		return priceHistoryDate;
	}

	public void setPriceHistoryDate(Date priceHistoryDate) {
		this.priceHistoryDate = priceHistoryDate;
	}
	
	

}
