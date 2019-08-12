public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length < 2) return 0;

        int[] minPrices = new int[prices.length];
        minPrices[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrices[i - 1]) {
                minPrices[i] = prices[i];
            } else {
                minPrices[i] = minPrices[i - 1];
            }
            if (prices[i] >= minPrices[i - 1] && max < prices[i] - minPrices[i - 1]) {
                max = prices[i] - minPrices[i - 1];
            }
        }
        return max;
    }
}