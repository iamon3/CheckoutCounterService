package com.freeorg.checkoutCounter.domain;

public class PurchasedProduct {

	private Long id;
	private String name;
	private Float priceRsPerKg;
	private Float applicableTaxPercent;
	private Float quantityKg;

	private Float priceAfterTax;
	
	public PurchasedProduct(){		
	}
	
	public PurchasedProduct(Long id, Float quantityKg) {
		this.id = id;
		this.quantityKg = quantityKg;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	public void setQuantityKg(Float qunatityKg) {
		this.quantityKg = qunatityKg;
	}
	
	public void setPrice(Float priceRsPerKg) {
		this.priceRsPerKg = priceRsPerKg;
	}
	
	public void setApplicableTaxPercent(Float applicableTaxPercent) {
		this.applicableTaxPercent = applicableTaxPercent;
		this.priceAfterTax = getPriceBeforeTax() * ((100 + this.applicableTaxPercent)/100);
	}
	
	public float getPriceAfterTax() {
		return this.priceAfterTax;
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

	public Float getApplicableTaxPercent() {
		return applicableTaxPercent;
	}

	public Float getQuantityKg() {
		return quantityKg;
	}

	public float getPriceBeforeTax() {
		return quantityKg * priceRsPerKg;
	}
	
}
