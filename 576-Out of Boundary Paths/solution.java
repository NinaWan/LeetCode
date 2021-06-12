class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};// up, down, left, right
        int mod = (int) 1e9 + 7;
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return findPaths(m, n, maxMove, startRow, startColumn, dirs, dp, mod);
    }

    private int findPaths(int m, int n, int maxMove, int i, int j, int[][] dirs, int[][][] dp, int mod) {
        if ((i < 0 || i >= m || j < 0 || j >= n) && maxMove >= 0) {
            return 1;
        }

        if (maxMove <= 0) {
            return 0;
        }

        if (dp[i][j][maxMove] >= 0) {
            return dp[i][j][maxMove];
        }

        long res = 0;
        for (int[] dir : dirs) {
            res = (res + findPaths(m, n, maxMove - 1, i + dir[0], j + dir[1], dirs, dp, mod) % mod) % mod;
        }

        dp[i][j][maxMove] = (int) res;
        return dp[i][j][maxMove];
    }
}