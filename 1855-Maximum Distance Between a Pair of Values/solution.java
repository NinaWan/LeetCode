class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            ans = Math.max(ans, binarySearch(nums2, nums1[i], i) - i);
        }

        return ans;
    }

    private int binarySearch(int[] nums, int target, int start) {
        int left = start, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
    }
}