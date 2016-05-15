package com.rbs.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rbs.order.domain.PurchaseItem;
import com.rbs.order.domain.PurchaseOrder;

import java.util.List;

public interface OrderRepository extends MongoRepository<PurchaseOrder, String> {
    
}