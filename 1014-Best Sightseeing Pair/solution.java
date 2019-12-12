class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int[] leftMax = new int[A.length - 1];
        int[] rightMax = new int[A.length - 1];
        leftMax[0] = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i] + i);
        }

        rightMax[A.length - 2] = A[A.length - 1] - (A.length - 1);
        for (int i = A.length - 3; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i + 1] - i - 1);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            result = Math.max(result, leftMax[i] + rightMax[i]);
        }

        return result;
    }
}