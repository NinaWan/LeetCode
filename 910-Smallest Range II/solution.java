class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int ans = A[A.length - 1] - A[0];

        for (int i = 0; i < A.length - 1; i++) {
            ans = Math.min(ans, Math.max(A[A.length - 1] - K, A[i] + K) - Math.min(A[i + 1] - K, A[0] + K));
        }

        return ans;
    }
}