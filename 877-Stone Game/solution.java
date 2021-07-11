class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];// dp[i][j] - max point for first minus max point for second, for piles[i...j]

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);// first player picks up the left pile or the right one
            }
        }

        return dp[0][n - 1] >= 0;
    }
}