package com.freeorg.checkoutCounter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
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

	private CheckoutCounterService mockCheckoutCounterScervice;
	private MockMvc mockMvc;
	private MediaType contentType;

	@Before
    public void setUp() {
		mockCheckoutCounterScervice = Mockito.mock(CheckoutCounterService.class);
		mockMvc = MockMvcBuilders.standaloneSetup(new CheckoutCounterController(mockCheckoutCounterScervice)).build();
		contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
				MediaType.APPLICATION_JSON.getSubtype(),
				Charset.forName("utf8"));
	}
	
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

		String expected = "{\"purchasedProductSet\": [],\"totalBillAmountAfterTax\": 0,\"totalBillAmountBeforeTax\": 0,\"totalTaxPercent\": 0}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
