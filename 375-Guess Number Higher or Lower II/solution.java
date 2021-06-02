class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {// for each possible guess
                    int max = k + Math.max(k == i ? 0
                                                  : dp[i][k - 1],
                            k == j ? 0
                                   : dp[k + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], max);
                }
            }
        }
        return dp[1][n];
    }
}