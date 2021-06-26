class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;

            int m = 1, j = 1;
            for (; j < i; j = (1 << ++m) - 1) {// case j<i
                for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
                }
            }

            if (j == i) {// case j=i
                dp[i] = Math.min(dp[i], m);
            } else {// case j>i
                dp[i] = Math.min(dp[i], m + 1 + dp[j - i]);
            }
        }

        return dp[target];
    }
}