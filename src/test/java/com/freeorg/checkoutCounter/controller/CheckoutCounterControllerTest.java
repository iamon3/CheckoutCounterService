package com.freeorg.checkoutCounter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freeorg.checkoutCounter.domain.GeneratedBill;
import com.freeorg.checkoutCounter.domain.PurchasedProduct;
import com.freeorg.checkoutCounter.service.CheckoutCounterService;

@RunWith(SpringRunner.class)
public class CheckoutCounterControllerTest {

	@MockBean
	private CheckoutCounterService mockCheckoutCounterScervice;

	private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new CheckoutCounterController(){
		@Override
		public CheckoutCounterService getCheckoutCounterService(){
			return mockCheckoutCounterScervice;
		}
	}).build();

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));


	@Test
	public void generateBill() throws Exception{
		// Given
		List<PurchasedProduct> mockPurchasedProductsList = new ArrayList<>();				
		GeneratedBill mockGeneratedBill = new GeneratedBill();
		Mockito.when(mockCheckoutCounterScervice.generateBill(mockPurchasedProductsList))
		.thenReturn(mockGeneratedBill);

		// When
		ObjectMapper mapper = new ObjectMapper();
		MvcResult result = mockMvc.perform(post("/bills")
				.content(mapper.writeValueAsString(mockPurchasedProductsList))
				.contentType(contentType))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();

		String expected = "{\"purchasedProductSet\": [],\"totalBillAmountAfterDiscount\": 0,\"totalBillAmountBeforeDiscount\": 0,\"discountPercent\": 0}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
