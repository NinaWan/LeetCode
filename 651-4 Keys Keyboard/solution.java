public class Solution {
    /**
     * @param N:
     *            an integer
     * @return: return an integer
     */
    public int maxA(int N) {
        int[] dp = new int[N + 1]; // dp[i] - maxA after pressing i times

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;// if current operation is presing A
            for (int j = 2; j < i; j++) {// if current operation is Ctrl-V
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));// try each last position for Ctrl-A Ctrl-V
            }
        }

        return dp[N];
    }
}