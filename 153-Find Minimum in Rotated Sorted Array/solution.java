class Solution {
    public int findMin(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[start]) {
                if (nums[end] > nums[start]) {
                    return nums[start];
                } else {
                    start = mid;
                }
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }
}