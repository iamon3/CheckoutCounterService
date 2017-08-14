package com.freeorg.checkoutCounter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeorg.checkoutCounter.domain.GeneratedBill;
import com.freeorg.checkoutCounter.domain.Product;
import com.freeorg.checkoutCounter.domain.PurchasedProduct;
import com.freeorg.checkoutCounter.repository.ProductRepository;

@Service
public class CheckoutCounterService {
	
	@Autowired
	private ProductRepository productRepository;

	public CheckoutCounterService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public GeneratedBill generateBill(List<PurchasedProduct> purchasedProductsList) {
		GeneratedBill generatedBill = new GeneratedBill();
		for(PurchasedProduct purchasedProduct: purchasedProductsList){
			Product product = productRepository.findOne(purchasedProduct.getId());
			purchasedProduct.setName(product.getName());
			purchasedProduct.setPrice(product.getPrice());
			purchasedProduct.setDiscountPercent(product.getDiscountPercent());
			generatedBill.addPurchasedProduct(purchasedProduct);			
		}		
		return generatedBill;
	}
}
