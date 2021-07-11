class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        for (int i = 0; i < n; i++) {
            points[i + 1] = nums[i];
        }
        points[0] = points[n + 1] = 1;
        int m = points.length;

        int[][] dp = new int[m][m];// (i, j) - max coins earned when burst all balloons in (i, j) exclusive
        for (int i = m; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }

        return dp[0][m - 1];
    }
}