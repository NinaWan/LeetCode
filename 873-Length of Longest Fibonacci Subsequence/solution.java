class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int result = 0;
        Map<Integer, Integer> posm = new HashMap();
        for (int i = 0; i < A.length; i++) {
            posm.put(A[i], i);
        }

        int[][] dp = new int[A.length][A.length];
        for (int k = 2; k < A.length; k++) {
            for (int j = 1; j < k; j++) {
                int i = posm.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    dp[j][k] = Math.max(dp[i][j], 2) + 1;
                    result = Math.max(result, dp[j][k]);
                }
            }
        }

        return result;
    }
}