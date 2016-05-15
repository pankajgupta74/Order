package com.rbs.order.service;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rbs.order.controller.OrderController;
import com.rbs.order.domain.PurchaseItem;
import com.rbs.order.domain.PurchaseOrder;
import com.rbs.order.domain.Receipt;
import com.rbs.order.repository.OrderRepository;

import com.rbs.order.util.OrderSequenceGenerator;

@Service
@Component
@ComponentScan("com.rbs.order.repository")

public class OrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderService.class);

	
	public OrderService() {
		super();
	}

	@Autowired
	private OrderRepository orderRepo;
	
	private Receipt receipt;
	
	public OrderRepository getItemRepo() {
		return orderRepo;
	}

	public void setOrderRepo(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	public Receipt placeOrder(List<PurchaseItem> items) throws Exception {
		
		double totalSurchargeAmount = 0.00;
		double totalPurchaseAmount = 0.00;
		
		logger.debug("Inside placeOrder");
		
		try {
		Object nextVal = OrderSequenceGenerator.getNextSequence("OrderSeq");
		
		String order_reference = (String)nextVal;
		
		logger.debug("Inside placeOrder, Order ref" + order_reference );;

		PurchaseOrder order = new PurchaseOrder(order_reference, items);
		orderRepo.save(order);
		
		logger.debug("Inside placeOrder, Order ref.. Order Saved");

		for (int i = 0; i < items.size(); i++) {
			PurchaseItem temp = items.get(i);
			totalPurchaseAmount+=temp.getTotalPrice();
			totalSurchargeAmount+=temp.getTotalSurcharge();
		}
		
			receipt = new Receipt(order_reference, items,totalPurchaseAmount,totalSurchargeAmount);
		} catch (Exception ex) {
			throw new Exception("Exception in placing an order" + ex.getMessage());
		}
		
		return receipt;
		
		
		
				
	}
	

}