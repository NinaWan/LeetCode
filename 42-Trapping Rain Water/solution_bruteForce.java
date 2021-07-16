class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        for (int i = 1; i < n - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            ans += Math.min(leftMax, rightMax) - height[i];
        }

        return ans;
    }
}