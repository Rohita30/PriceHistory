package com.pricehistory.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table
public class PriceHistory {

	@Id
	@GeneratedValue
	private Long priceHistoryId;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@OneToOne
	@JoinColumn(name = "retailer_id")
	private Retailer retailer;
	@Column
	private Float priceHistoryPrice;
	@CreatedDate
	@Column
	private Date priceHistoryDate;

	public PriceHistory(Long priceHistoryId, Product product, Retailer retailer, Float priceHistoryPrice,
			Date priceHistoryDate) {
		super();
		this.priceHistoryId = priceHistoryId;
		this.product = product;
		this.retailer = retailer;
		this.priceHistoryPrice = priceHistoryPrice;
		this.priceHistoryDate = priceHistoryDate;
	}

	public PriceHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPriceHistoryId() {
		return priceHistoryId;
	}

	public void setPriceHistoryId(Long priceHistoryId) {
		this.priceHistoryId = priceHistoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
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
