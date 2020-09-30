class Solution {

    public int maxProfit(int[] prices) {
        return linearTimeMaxProfit(prices);
    }

    public int linearTimeMaxProfit(int[] prices) {
        int currentMaxDifference = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentDifference = currentMaxDifference + prices[i] - prices[i - 1];
            currentMaxDifference = Math.max(0, currentDifference);
            profit = Math.max(profit, currentMaxDifference);
        }

        return profit;
    }

    public int polynomialTimeMaxProfit(int[] prices) {
        int profit = 0;

        for (int buyIndex = 0; buyIndex < prices.length - 1; buyIndex++) {
            int buy = prices[buyIndex];
            for (int sellIndex = buyIndex + 1; sellIndex < prices.length; sellIndex++) {
                int sell = prices[sellIndex];
                int diff = sell - buy;
                profit = Math.max(profit, diff);
            }
        }

        return profit;
    }

}
