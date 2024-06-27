package com.simulation.swimmingpool_ticketing.controller;

import com.simulation.swimmingpool_ticketing.dto.OrderRequest;
import com.simulation.swimmingpool_ticketing.dto.OrderResponse;
import com.simulation.swimmingpool_ticketing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }
}
