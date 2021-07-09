class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], n = nums.length;
        int dp0 = nums[0], dp1 = nums[0];

        for (int i = 1; i < n; i++) {
            dp1 = Math.max(dp0 + nums[i], nums[i]);
            dp0 = dp1;
            ans = Math.max(ans, dp1);
        }

        return ans;
    }
}