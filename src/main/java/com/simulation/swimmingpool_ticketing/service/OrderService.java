package com.simulation.swimmingpool_ticketing.service;

import com.simulation.swimmingpool_ticketing.dto.ListOrderRequest;
import com.simulation.swimmingpool_ticketing.dto.OrderRequest;
import com.simulation.swimmingpool_ticketing.dto.OrderResponse;
import com.simulation.swimmingpool_ticketing.model.Category;
import com.simulation.swimmingpool_ticketing.model.Order;
import com.simulation.swimmingpool_ticketing.repository.CategoryRepository;
import com.simulation.swimmingpool_ticketing.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CategoryRepository categoryRepository){
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<OrderResponse> createOrder(OrderRequest request){
        Integer totalAmount = 0;

        for (ListOrderRequest list: request.getListOrderRequests()){
            Optional<Category> category = categoryRepository.findById(list.getCategoryId());
            if (category.isPresent()) {
                totalAmount += category.get().getPrice() * list.getQty();
            }
        }

        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setTotalAmount(totalAmount);
        order.setOrderDate(new Date());
        Order orderSaved = orderRepository.save(order);

        OrderResponse response = new OrderResponse();
        response.setCustomerName(orderSaved.getCustomerName());
        response.setTotalAmount(orderSaved.getTotalAmount());
        response.setOrderDate(orderSaved.getOrderDate());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
