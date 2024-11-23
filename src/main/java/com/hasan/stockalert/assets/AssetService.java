package com.hasan.stockalert.assets;

import com.hasan.stockalert.assets.dto.AssetData;
import com.hasan.stockalert.assets.dto.StockData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AssetService {
    @Value("${finnhub.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public StockData getStockData(String symbol) {
        String url = String.format("https://finnhub.io/api/v1/quote?symbol=%s&token=%s", symbol, apiKey);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response == null) {
            throw new RuntimeException("Failed to fetch stock data for symbol: " + symbol);
        }

        return StockData.builder()
                .symbol(symbol)
                .name("") // TODO: Implement company name fetching
                .price(convertToDouble(response.get("c")))
                .volume(convertToDouble(response.get("v")))
                .change(convertToDouble(response.get("d")))
                .open(convertToDouble(response.get("o")))
                .high(convertToDouble(response.get("h")))
                .low(convertToDouble(response.get("l")))
                .previousClose(convertToDouble(response.get("pc")))
                .build();
    }

    private double convertToDouble(Object value) {
        if (value == null) {
            return 0.0;
        }
        if (value instanceof Integer) {
            return ((Integer) value).doubleValue();
        }
        return value instanceof Double ? (Double) value : 0.0;
    }

    public AssetData getCryptoData(String symbol) {
        // TODO: Implement crypto data fetching
        return null;
    }

    public AssetData getBondData(String symbol) {
        // TODO: Implement bond data fetching
        return null;
    }

    public AssetData getCommodityData(String symbol) {
        // TODO: Implement commodity data fetching
        return null;
    }
}