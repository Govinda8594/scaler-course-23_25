package com.scaler.Scaler.Arrays;

public class StockBuySellMaxProfilt {
    public int maxProfit(final int[] A) {
        int priceOfStock = Integer.MAX_VALUE, maxprofit = 0;
        for (int j : A) {
            priceOfStock = Math.min(priceOfStock, j);
            int profit = j - priceOfStock;
            maxprofit = Math.max(maxprofit, profit);
        }
        return maxprofit;
    }
}
