class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profitMax = 0;
        int balanceMax = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            profitMax = Math.max(profitMax, balanceMax + prices[i] - fee);
            balanceMax = Math.max(balanceMax, profitMax - prices[i]);
        }

        return profitMax;
    }
}