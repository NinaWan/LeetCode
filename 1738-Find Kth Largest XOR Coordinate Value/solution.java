class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[] sorted = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[0][0];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] ^ matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] ^ matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
                }
                sorted[i * n + j] = dp[i][j];
            }
        }

        Arrays.sort(sorted);

        return sorted[m * n - k];
    }
}