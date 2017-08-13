package com.freeorg.checkoutCounter.domain;

import java.util.HashSet;
import java.util.Set;

public class GeneratedBill {

	private Set<PurchasedProduct> purchasedProductSet = new HashSet<>();
	private float totalBillAmountAfterDiscount = 0.0f;
	private float totalBillAmountBeforeDiscount = 0.0f;
	private float discountPercent;
	
	public float getTotalBillAmountBeforeDiscount() {
		return totalBillAmountBeforeDiscount;
	}

	public void addPurchasedProduct(PurchasedProduct purchasedProduct) {
		purchasedProductSet.add(purchasedProduct);
		this.totalBillAmountBeforeDiscount += purchasedProduct.getPrice();
		this.totalBillAmountAfterDiscount += purchasedProduct.getDiscountedPrice();
		this.discountPercent = ((totalBillAmountBeforeDiscount -totalBillAmountAfterDiscount)/ totalBillAmountBeforeDiscount)*100;
	}

	public float getDiscountPercent() {
		return discountPercent;
	}

	public Set<PurchasedProduct> getPurchasedProductSet() {
		return purchasedProductSet;
	}

	public float gettotalBillAmountAfterDiscount() {
		return totalBillAmountAfterDiscount;
	}
}
