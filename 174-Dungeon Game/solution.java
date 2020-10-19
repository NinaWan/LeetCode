class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = -dungeon[i][j];

                if (i != m - 1 && j != n - 1) {
                    need += Math.min(dp[i][j + 1], dp[i + 1][j]);
                } else if (i == m - 1 && j != n - 1) {
                    need += dp[i][j + 1];
                } else if (j == n - 1 && i != m - 1) {
                    need += dp[i + 1][j];
                } else {
                    need += 1;
                }

                dp[i][j] = need <= 0 ? 1 : need;
            }
        }

        return dp[0][0];
    }
}