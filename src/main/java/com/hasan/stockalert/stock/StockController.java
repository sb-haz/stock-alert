package com.hasan.stockalert.stock;

import com.hasan.stockalert.stock.dto.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping("/{symbol}")
    public StockQuote getStock(@PathVariable String symbol) {
        return stockService.getStockPrice(symbol);
    }
}
