class Solution {
    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, dp, m, n);
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp, int m, int n) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int res = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y]) {
                res = Math.max(res, dfs(matrix, x, y, dp, m, n) + 1);
            }
        }

        dp[i][j] = res;
        return res;
    }
}