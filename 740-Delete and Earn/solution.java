class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] points = new int[10001];
        for (int num : nums) {
            points[num] += num;
        }

        int[] dp = new int[10001];// dp[i] - max points can be earned with range [0, i]
        dp[0] = points[0];
        dp[1] = points[1];
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 1], points[i] + dp[i - 2]); // not take number i's point or take number ith point
        }

        return dp[10000];
    }
}