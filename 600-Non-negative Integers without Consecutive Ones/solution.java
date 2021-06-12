class Solution {
    public int findIntegers(int n) {
        int[] dp = new int[32];// dp[i] - number of length k string without consecutive 1
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int ans = 0, pre = 0;
        for (int k = 30; k >= 0; k--) {
            if ((n & (1 << k)) != 0) {// if n's (k+1)th bit is 1
                ans += dp[k];
                if (pre == 1) {// consecutive ones found
                    return ans;
                }
                pre = 1;
            } else {
                pre = 0;
            }
        }

        return ans + 1;
    }
}