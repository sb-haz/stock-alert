package com.hasan.stockalert.assets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AssetData {
    private String symbol;
    private String name;
    private double price;
    private double volume;
    private double change;
}