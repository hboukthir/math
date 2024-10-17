package org.example;

import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private Map<String, Integer> stock = new HashMap<>();
    private static final int LOW_STOCK_THRESHOLD = 5; // seuil de stock bas

    public void addItem(String itemName, int quantity) {
        stock.put(itemName, stock.getOrDefault(itemName, 0) + quantity);
    }

    public void removeItem(String itemName, int quantity) {
        if (stock.containsKey(itemName)) {
            stock.put(itemName, stock.get(itemName) - quantity);
            if (stock.get(itemName) < 0) {
                stock.put(itemName, 0); // Eviter les stocks négatifs
            }
        }
    }

    public boolean isStockLow(String itemName) {
        return stock.getOrDefault(itemName, 0) < LOW_STOCK_THRESHOLD;
    }
}
