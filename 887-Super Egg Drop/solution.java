class Solution {
    public int superEggDrop(int k, int n) {
        int ans = 0;
        int[][] dp = new int[n + 1][k + 1];// max floor can reach, with i moves and j eggs

        while (dp[ans][k] < n) {
            ans++;
            for (int j = 1; j <= k; j++) {
                dp[ans][j] = dp[ans - 1][j] + dp[ans - 1][j - 1] + 1;
            }
        }

        return ans;
    }
}