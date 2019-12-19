class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = mat[i][j];
                    continue;
                }

                if (i == 0) {
                    sum[i][j] = sum[i][j - 1] + mat[i][j];
                    continue;
                }

                if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + mat[i][j];
                    continue;
                }

                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i][j];
            }
        }

        for (int sl = Math.min(m, n); sl > 0; sl--) {
            for (int i = sl - 1; i < m; i++) {
                for (int j = sl - 1; j < n; j++) {
                    int tempSum = sum[i][j];

                    if (i != sl - 1) {
                        tempSum -= sum[i - sl][j];
                    }
                    if (j != sl - 1) {
                        tempSum -= sum[i][j - sl];
                    }
                    if (i != sl - 1 && j != sl - 1) {
                        tempSum += sum[i - sl][j - sl];
                    }

                    if (tempSum <= threshold) {
                        return sl;
                    }
                }
            }
        }

        return 0;
    }
}