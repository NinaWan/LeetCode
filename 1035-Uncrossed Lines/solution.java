class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];

        // initialization
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[0]) {
                while (i < A.length) {
                    dp[i][0] = 1;
                    i++;
                }
            }
        }

        for (int i = 0; i < B.length; i++) {
            if (A[0] == B[i]) {
                while (i < B.length) {
                    dp[0][i] = 1;
                    i++;
                }
            }
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[A.length - 1][B.length - 1];
    }
}