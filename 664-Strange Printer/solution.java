class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i < n - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1
                                                              : 2;
            }
        }

        for (int len = 2; len < n; len++) {
            for (int i = 0, j = i + len; i < n - len; i++, j++) {
                dp[i][j] = len + 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], s.charAt(k) == s.charAt(j) ? dp[i][k] + dp[k + 1][j] - 1
                                                                             : dp[i][k] + dp[k + 1][j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}