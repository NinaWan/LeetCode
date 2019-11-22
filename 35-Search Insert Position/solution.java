class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start + 1 < end) {
            mid = (end - start) / 2 + start;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] < target && nums[end] > target) {
            return end;
        }

        if (nums[start] > target) {
            return start;
        }

        if (nums[end] < target) {
            return end + 1;
        }

        return nums[start] == target ? start : end;
    }
}