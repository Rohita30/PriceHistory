package com.pricehistory.Dto;

import java.sql.Date;

public class PriceHistoryUpdateDto { 
	
	private Float priceHistoryPrice;
	
	private Date priceHistoryDate;

	public PriceHistoryUpdateDto(Float priceHistoryPrice, Date priceHistoryDate) {
		super();
		this.priceHistoryPrice = priceHistoryPrice;
		this.priceHistoryDate = priceHistoryDate;
	}

	public PriceHistoryUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
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
