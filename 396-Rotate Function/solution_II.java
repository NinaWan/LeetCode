class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int F = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            F += i * A[i];
        }

        int ans = F;
        for (int i = 1; i < A.length; i++) {
            F = F + sum - A.length * A[A.length - i];
            ans = Math.max(ans, F);
        }

        return ans;
    }
}