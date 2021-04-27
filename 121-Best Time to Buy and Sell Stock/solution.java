class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int max = 0;
        int[] minPrices = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            minPrices[i] = i != 0 ? Math.min(minPrices[i - 1], prices[i])
                                  : prices[i];
            max = Math.max(max, prices[i] - minPrices[i]);
        }

        return max;
    }
}