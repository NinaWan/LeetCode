class Solution {
    public boolean search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] < nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[start] > nums[mid]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }

        if (nums[start] == target) {
            return true;
        }

        if (nums[end] == target) {
            return true;
        }

        return false;
    }
}