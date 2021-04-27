class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) ||
                    (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])) {
                return mid;
            }

            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums[start] > nums[end] ? start
                                       : end;
    }
}