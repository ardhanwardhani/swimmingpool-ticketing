package com.simulation.swimmingpool_ticketing.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String customerName;
    private List<ListOrderRequest> listOrderRequests;
}
