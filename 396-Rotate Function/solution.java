class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;

        for (int k = 0; k < A.length; k++) {
            long sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += i * A[(i - k + A.length) % A.length];
            }
            ans = Math.max(ans, (int) sum);
        }

        return ans;
    }
}