class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = 0;
        int rightMin = n;

        for (int l : left) {
            leftMax = Math.max(leftMax, l);
        }

        for (int r : right) {
            rightMin = Math.min(rightMin, r);
        }

        return Math.max(leftMax, n - rightMin);
    }
}