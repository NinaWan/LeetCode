class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];// Max profit till index i. The series of transaction is ending with a buy.
        int[] sell = new int[n];// Max profit till index i. The series of transaction is ending with a sell.
        buy[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            buy[i] = Math.max((i < 2 ? 0
                                     : sell[i - 2]) -
                    prices[i], buy[i - 1]);// buy at ith day or rest at ith day
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);// sell at ith day or rest at ith day
        }

        return sell[n - 1];
    }
}