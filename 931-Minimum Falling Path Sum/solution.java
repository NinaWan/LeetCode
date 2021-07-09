class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int[] me : memo) {
            Arrays.fill(me, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp(matrix, m - 1, j, memo));
        }

        return ans;
    }

    private int dp(int[][] matrix, int i, int j, int[][] memo) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }

        memo[i][j] = matrix[i][j] + Math.min(dp(matrix, i - 1, j - 1, memo), Math.min(dp(matrix, i - 1, j, memo), dp(matrix, i - 1, j + 1, memo)));
        return memo[i][j];
    }
}