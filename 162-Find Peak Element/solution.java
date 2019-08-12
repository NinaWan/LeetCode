class Solution {
    public int findPeakElement(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                start = mid;
                continue;
            }

            if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
                end = mid;
                continue;
            }

            end = mid;
        }

        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }
}