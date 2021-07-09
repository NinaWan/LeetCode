class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }

        int n = nums.length, t = (sum + target) / 2;
        int[][] dp = new int[n + 1][t + 1];// dp[i][j] - number of ways using first ith numbers to reach sum j

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];// can pick up or not
                } else {
                    dp[i][j] = dp[i - 1][j];// can't pick up
                }
            }
        }

        return dp[n][t];
    }

}