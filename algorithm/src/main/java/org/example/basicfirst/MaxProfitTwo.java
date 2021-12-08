package org.example.basicfirst;

public class MaxProfitTwo {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int total = 0, index = 0, length = prices.length;
        while (index < length) {
            // 说明股价下跌，不需要计算
            while (index < length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            int minPrice = prices[index];
            // 股价上涨，找到上涨的最大值
            while (index < length - 1 && prices[index] < prices[index + 1]) {
                index++;
            }
            total += prices[index] - minPrice;
            index++;
        }
        return total;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            total += Math.max(prices[i + 1] - prices[i], 0);
        }
        return total;
    }
}
