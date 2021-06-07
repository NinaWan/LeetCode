class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if (len == 0) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1] >= 0;
    }
}