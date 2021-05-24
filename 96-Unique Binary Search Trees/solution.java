class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int m = 1; m <= n; m++) {// for each count of nodes
            for (int r = 1; r <= m; r++) {// for each number in [1, m] as root
                dp[m] += dp[r - 1] * dp[m - r];
            }
        }

        return dp[n];
    }
}