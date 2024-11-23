package com.hasan.stockalert.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StockService {
    @Value("${finnhub.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public Object getStockData(String symbol) {
        String url = String.format("https://finnhub.io/api/v1/quote?symbol=%s&token=%s", symbol, apiKey);
        return restTemplate.getForObject(url, Object.class);
    }
}