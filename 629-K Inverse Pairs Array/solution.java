class Solution {
    public int kInversePairs(int n, int k) {
        int m = n * (n - 1) / 2;// max possible number of inverse pairs
        if (k > m) {
            return 0;
        }

        if (k == 0 || k == m) {
            return 1;
        }

        int mod = (int) 1e9 + 7;
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;// k=0, only one valid array
            for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] -= j >= i ? dp[i - 1][j - i]
                                   : 0;
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }

        return (int) dp[n][k];
    }
}