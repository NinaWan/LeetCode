class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;// copy all only once
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;// 1(copy all) + (i/j-1)(paste)
                    break;
                }
            }
        }

        return dp[n];
    }
}