class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[end] > nums[start]) {
                return nums[start];
            }

            if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}