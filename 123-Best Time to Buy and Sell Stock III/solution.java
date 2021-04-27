class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] leftMax = new int[prices.length];
        leftMax[0] = 0;
        int[] rightMax = new int[prices.length];
        rightMax[prices.length - 1] = 0;

        int minPrice = prices[0];
        int maxPrice = prices[prices.length - 1];
        int maxPro = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPrice);
            leftMax[i] = maxPro;
        }

        maxPro = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxPro = Math.max(maxPro, maxPrice - prices[i]);
            rightMax[i] = maxPro;
        }

        maxPro = 0;
        for (int i = 0; i < prices.length; i++) {
            maxPro = Math.max(maxPro, i == prices.length - 1 ? leftMax[i]
                                                             : leftMax[i] + rightMax[i + 1]);
        }

        return maxPro;
    }
}