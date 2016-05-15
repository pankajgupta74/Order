package com.rbs.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.rbs.order.domain.PurchaseItem;
import com.rbs.order.domain.Receipt;
import com.rbs.order.service.OrderService;

@RestController
@ComponentScan("com.rbs.order.service")
public class OrderController {

	@Autowired
	private OrderService service;

	@CrossOrigin(origins = {"http://webapp-dummycompany.rhcloud.com", "http://localhost:8080"})
	@RequestMapping("/order")
	public @ResponseBody Receipt order(@RequestParam("orderItems") String itemsStr) {

		Receipt receipt = null;
		System.out.println("in purchase" + itemsStr);
		List<PurchaseItem> items = null;

		ObjectMapper mapper = new ObjectMapper();
		try {

			List<PurchaseItem> list = mapper.readValue(itemsStr,
					TypeFactory.defaultInstance().constructCollectionType(List.class, PurchaseItem.class));

			System.out.println("entering placeOrder");
			receipt = service.placeOrder(list);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return receipt;
	}

}
