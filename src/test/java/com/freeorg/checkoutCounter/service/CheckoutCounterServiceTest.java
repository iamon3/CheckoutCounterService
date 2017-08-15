package com.freeorg.checkoutCounter.service;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.freeorg.checkoutCounter.domain.Category;
import com.freeorg.checkoutCounter.domain.GeneratedBill;
import com.freeorg.checkoutCounter.domain.Product;
import com.freeorg.checkoutCounter.domain.PurchasedProduct;
import com.freeorg.checkoutCounter.repository.ProductRepository;

public class CheckoutCounterServiceTest {
	
	private CheckoutCounterService checkoutCounterService;
	private ProductRepository mockedProductRepository;
	
	@Before
    public void setUp() {
		mockedProductRepository = Mockito.mock(ProductRepository.class);
		checkoutCounterService = new CheckoutCounterService(mockedProductRepository);
	}
	
	@Test
	public void generateBill(){
		// Given
		List<PurchasedProduct> mockPurchasedProductsList = getMockPurchasedProductList();
		when(mockedProductRepository.findOne(1l))
		.thenReturn(new Product(1l,"Sugar", Category.A, 10.0f));
		when(mockedProductRepository.findOne(3l))
		.thenReturn(new Product(3l,"Rice", Category.B, 10.0f));
		
		// When
		GeneratedBill generatedBill = checkoutCounterService.generateBill(mockPurchasedProductsList);
		
		// Then
		Assert.assertEquals(30.0, generatedBill.getTotalBillAmountBeforeTax(), 0.0);
		Assert.assertEquals(35.0, generatedBill.getTotalBillAmountAfterTax(), 0.0);
		Assert.assertEquals(16.67,generatedBill.getTotalTaxPercent(),0.01);
		Assert.assertTrue(2 == generatedBill.getPurchasedProductSet().size());
	}
	
	private List<PurchasedProduct> getMockPurchasedProductList(){
		List<PurchasedProduct> mockPurchasedProductsList = new ArrayList<>();
		mockPurchasedProductsList.add(new PurchasedProduct(1l, 1.0f));
		mockPurchasedProductsList.add(new PurchasedProduct(3l, 2.0f));
		return mockPurchasedProductsList;
	}
}
