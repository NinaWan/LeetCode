class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] moduloCount = new int[K];
        int[] sum = new int[A.length];
        sum[0] = A[0];
        moduloCount[(sum[0] % K + K) % K] = 1;

        for (int i = 1; i < A.length; i++) {
            sum[i] = A[i] + sum[i - 1];
            moduloCount[(sum[i] % K + K) % K]++;// include zero, negative and positive cases
        }

        int result = moduloCount[0];
        for (int i = 0; i < K; i++) {
            result += moduloCount[i] * (moduloCount[i] - 1) / 2;
        }

        return result;
    }
}