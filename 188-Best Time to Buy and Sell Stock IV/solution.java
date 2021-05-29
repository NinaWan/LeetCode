class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        if (k >= n / 2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxPro += prices[i] - prices[i - 1];
                }
            }
            return maxPro;
        }

        int[][] dp = new int[k + 1][n];// (i, j) - maximum profit from at most i transactions using prices[0..j]
        for (int i = 1; i <= k; i++) {
            int max = -prices[0];
            for (int j = 1; j < n; j++) {
                // not selling
                // or selling - max(p[j]-p[t]+dp[i-1][t-1]), t ∈ [0, j-1]
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
                max = Math.max(max, dp[i - 1][j - 1] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }
}