class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n]; // dp[i][j] - minimum HP needed from [i, j] to [m-1, n-1]

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int needed = -dungeon[i][j];

                if (i != m - 1 && j != n - 1) {
                    needed += Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else if (i == m - 1 && j == n - 1) {
                    needed += 1;
                } else if (i == m - 1) {
                    needed += dp[i][j + 1];
                } else if (j == n - 1) {
                    needed += dp[i + 1][j];
                }

                dp[i][j] = needed <= 0 ? 1
                                       : needed;
            }
        }

        return dp[0][0];
    }
}