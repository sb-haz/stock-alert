package com.hasan.stockalert.assets;

import com.hasan.stockalert.assets.dto.AssetData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;

    @GetMapping("/{assetType}/{symbol}")
    public ResponseEntity<AssetData> getAsset(
            @PathVariable AssetType assetType,
            @PathVariable String symbol) {
        try {
            AssetData assetData = switch (assetType) {
                case STOCK -> assetService.getStockData(symbol);
                case CRYPTO -> assetService.getCryptoData(symbol);
                case BOND -> assetService.getBondData(symbol);
                case COMMODITY -> assetService.getCommodityData(symbol);
            };

            if (assetData == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(assetData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}