package com.freeorg.checkoutCounter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freeorg.checkoutCounter.domain.GeneratedBill;
import com.freeorg.checkoutCounter.domain.PurchasedProduct;
import com.freeorg.checkoutCounter.service.CheckoutCounterService;

@RestController
public class CheckoutCounterController {
	
	@Autowired
	private CheckoutCounterService checkoutCounterService;

	@RequestMapping(value="/bills", method = RequestMethod.POST)
	public GeneratedBill generateBill(@RequestBody List<PurchasedProduct> purchasedProductsList){
		return getCheckoutCounterService().generateBill(purchasedProductsList);
	}
	// TODO For the test case, this method was needed. Try to get rid of this.
	public CheckoutCounterService getCheckoutCounterService(){
		return this.checkoutCounterService;
	}
}
