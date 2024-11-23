package com.hasan.stockalert.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping("/{symbol}")
    public ResponseEntity<Object> getStockData(@PathVariable String symbol) {
        try {
            return ResponseEntity.ok(stockService.getStockData(symbol));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}