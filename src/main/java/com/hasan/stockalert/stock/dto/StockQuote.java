package com.hasan.stockalert.stock.dto;

import lombok.Data;

@Data
public class StockQuote {
    private double c;    // Current price
    private double d;    // Change
    private double dp;   // Percent change
    private double h;    // High price of the day
    private double l;    // Low price of the day
    private double o;    // Open price of the day
    private double pc;   // Previous close price
    private long t;      // Timestamp
}
