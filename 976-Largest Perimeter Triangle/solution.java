class Solution {
    public int largestPerimeter(int[] A) {
        int ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                ans = Math.max(ans, A[i] + A[i + 1] + A[i + 2]);
            }
        }

        return ans;
    }
}