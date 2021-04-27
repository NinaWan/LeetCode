class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0, j = height.length - 1; i < j;) {
            int currArea = (j - i) * Math.min(height[i], height[j]);

            if (currArea > maxArea) {
                maxArea = currArea;
            }

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}