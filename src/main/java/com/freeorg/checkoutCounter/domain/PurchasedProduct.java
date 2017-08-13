package com.freeorg.checkoutCounter.domain;

public class PurchasedProduct {

	private Long id;
	private String name;
	private Float priceRsPerKg;
	private Float discountPercent;
	private Float qunatityKg;

	private Float discountedPrice;
	
	public Long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	public void setQunatityKg(Float qunatityKg) {
		this.qunatityKg = qunatityKg;
	}
	
	public void setPrice(Float priceRsPerKg) {
		this.priceRsPerKg = priceRsPerKg;
	}
	
	public void setDiscountPercent(Float discountPercent) {
		this.discountPercent = discountPercent;
		this.discountedPrice = qunatityKg * priceRsPerKg * ((100 - this.discountPercent)/100);
	}
	
	public float getDiscountedPrice() {
		return this.discountedPrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Float getPriceRsPerKg() {
		return priceRsPerKg;
	}

	public Float getDiscountPercent() {
		return discountPercent;
	}

	public Float getQunatityKg() {
		return qunatityKg;
	}

	public float getPrice() {
		return qunatityKg * priceRsPerKg;
	}
	
}
