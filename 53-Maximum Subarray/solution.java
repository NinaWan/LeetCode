class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], n = nums.length;
        int[] dp = new int[n]; // dp[i] - largest sum ending at ith number
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}