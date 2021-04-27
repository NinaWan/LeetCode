class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int totalSum = 0, minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;
        int currMinSum = 0, currMaxSum = 0;
        for (int i = 0; i < A.length; i++) {
            currMaxSum = Math.max(currMaxSum + A[i], A[i]);
            maxSum = Math.max(maxSum, currMaxSum);
            currMinSum = Math.min(currMinSum + A[i], A[i]);
            minSum = Math.min(minSum, currMinSum);
            totalSum += A[i];
        }

        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum)
                          : maxSum;
    }
}