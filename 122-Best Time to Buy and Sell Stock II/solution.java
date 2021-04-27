class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int max = 0;
        int bottom = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (bottom >= prices[i]) {
                bottom = prices[i];
                continue;
            }

            if (i == prices.length - 1 || prices[i] >= prices[i + 1]) {
                max += prices[i] - bottom;
                bottom = i == prices.length - 1 ? bottom
                                                : prices[i + 1];
            }
        }

        return max;
    }
}