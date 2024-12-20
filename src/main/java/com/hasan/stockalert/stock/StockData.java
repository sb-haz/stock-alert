package com.hasan.stockalert.stock;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockData {
    private String symbol;
    private String name;
    private double price;
    private double change;
}
