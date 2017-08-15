package com.freeorg.checkoutCounter.domain;

import java.util.HashSet;
import java.util.Set;

public class GeneratedBill {

	private Set<PurchasedProduct> purchasedProductSet = new HashSet<>();
	private float totalBillAmountAfterTax = 0.0f;
	private float totalBillAmountBeforeTax = 0.0f;
	private float totalTaxPercent;
	
	public float getTotalBillAmountBeforeTax() {
		return totalBillAmountBeforeTax;
	}

	public void addPurchasedProduct(PurchasedProduct purchasedProduct) {
		purchasedProductSet.add(purchasedProduct);
		this.totalBillAmountBeforeTax += purchasedProduct.getPriceBeforeTax();
		this.totalBillAmountAfterTax += purchasedProduct.getPriceAfterTax();
		this.totalTaxPercent = ((totalBillAmountAfterTax - totalBillAmountBeforeTax)/ totalBillAmountBeforeTax)*100;
	}

	public float getTotalTaxPercent() {
		return totalTaxPercent;
	}

	public Set<PurchasedProduct> getPurchasedProductSet() {
		return purchasedProductSet;
	}

	public float getTotalBillAmountAfterTax() {
		return totalBillAmountAfterTax;
	}
}
