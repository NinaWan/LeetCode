class Solution {
    public int findLength(int[] A, int[] B) {
        int lA = A.length;
        int lB = B.length;
        int[][] dp = new int[lA + 1][lB + 1];// the longest common subarray when ends at Ai and Bj
        int maxLength = 0;

        for (int i = 0; i < lA; i++) {
            for (int j = 0; j < lB; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }

                maxLength = Math.max(maxLength, dp[i + 1][j + 1]);
            }
        }

        return maxLength;
    }
}