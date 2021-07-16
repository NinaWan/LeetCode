class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0, left = 0, right = n - 1;

        if (height.length == 0) {
            return 0;
        }

        int leftMax = height[0];
        int rightMax = height[n - 1];

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
    }
}