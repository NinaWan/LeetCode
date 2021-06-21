class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int dp_i10 = 0, dp_i20 = 0, dp_i11 = Integer.MIN_VALUE, dp_i21 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
        }

        return Math.max(dp_i20, dp_i21);
    }
}