class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }

        double[][] dp = new double[n][k + 1];
        for (int group = 1; group <= k; group++) {
            for (int i = 0; i + group <= n; i++) {
                if (group == 1) {
                    dp[i][group] = ((double) (preSum[n - 1] - preSum[i] + nums[i])) / (n - i);
                    continue;
                }

                for (int j = i; j + group <= n; j++) {
                    dp[i][group] = Math.max(dp[i][group], dp[j + 1][group - 1] + ((double) (preSum[j] - preSum[i] + nums[i])) / (j - i + 1));
                }
            }
        }

        return dp[0][k];
    }
}