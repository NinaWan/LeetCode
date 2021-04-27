class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int result = 0;
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }

        for (int i = -1; i < A.length - M - L; i++) {
            for (int j = i + L; j < A.length - M; j++) {
                int lsum = i == -1 ? sum[i + L]
                                   : sum[i + L] - sum[i];
                result = Math.max(result, lsum + sum[j + M] - sum[j]);
            }
        }

        for (int i = -1; i < A.length - M - L; i++) {
            for (int j = i + M; j < A.length - L; j++) {
                int msum = i == -1 ? sum[i + M]
                                   : sum[i + M] - sum[i];
                result = Math.max(result, msum + sum[j + L] - sum[j]);
            }
        }

        return result;
    }
}