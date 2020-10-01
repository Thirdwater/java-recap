class Solution {
    public int maxProfit(int[] prices) {
        int profits = 0;
        int tally = 0;
        for (int i = 1; i < prices.length; i++) {
            int difference = prices[i] - prices[i - 1];
            if (difference <= 0) {
                profits += tally;
                tally = 0;
            } else {
                tally = Math.max(0, tally + difference);
            }
        }
        profits += tally;
        return profits;
    }
}
