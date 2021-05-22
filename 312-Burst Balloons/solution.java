class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] dump = new int[n + 2];
        for (int i = 0; i < n; i++) {
            dump[i + 1] = nums[i];
        }
        dump[0] = dump[n + 1] = 1;
        int m = dump.length;

        int[][] dp = new int[m][m];// (i, j) - max coins earned when burst all balloons in (i, j) exclusive
        for (int k = 2; k < m; k++) {
            for (int l = 0; l < m - k; l++) {
                int r = l + k;
                for (int i = l + 1; i < r; i++) {
                    dp[l][r] = Math.max(dp[l][r], dump[l] * dump[i] * dump[r] + dp[l][i] + dp[i][r]);
                }
            }
        }

        return dp[0][m - 1];
    }
}