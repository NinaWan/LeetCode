class Solution {
    private int[][] dirs = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        return knightProbability(n, k, row, column, new double[n][n][k + 1]);
    }

    private double knightProbability(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || column > n - 1 || row > n - 1 || column < 0) {
            return 0.0;
        }

        if (k == 0) {
            return 1;
        }

        if (dp[row][column][k] != 0) {
            return dp[row][column][k];
        }

        double res = 0.0;
        for (int[] dir : dirs) {
            res += 0.125 * knightProbability(n, k - 1, row + dir[0], column + dir[1], dp);
        }

        dp[row][column][k] = res;

        return res;
    }
}