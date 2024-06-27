package com.simulation.swimmingpool_ticketing.dto;

import lombok.Data;

@Data
public class ListOrderRequest {
    private Long categoryId;
    private Integer qty;
}
