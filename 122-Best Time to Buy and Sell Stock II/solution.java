public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int result = 0;
        int bottom = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (bottom >= prices[i]) {
                bottom = prices[i];
                continue;
            }

            if (i + 1 == prices.length) {
                result += prices[i] - bottom;
                continue;
            }

            if (i + 1 < prices.length && prices[i + 1] < prices[i]) {
                result += prices[i] - bottom;
                bottom = prices[i + 1];
            }
        }

        return result;
    }
}