package com.freeorg.checkoutCounter.domain;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	public Product(){
	}
	
	public Product(Long id, String name, Category category, Float price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	private String name;
	
	// priceRsPerKg
	private Float price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float priceRsPerKg) {
		this.price = priceRsPerKg;
	}
	
	public Float getApplicableTaxPercent() {
		return this.category.getApplicableTaxPercent();
	}
	
}
