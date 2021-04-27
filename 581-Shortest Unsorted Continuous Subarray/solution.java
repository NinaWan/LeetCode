class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // find the first falling point from left to right
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }

            while (i < nums.length) {
                min = Math.min(min, nums[i]);
                i++;
            }
        }

        // find the first rising point from right to left
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }

            while (i >= 0) {
                max = Math.max(max, nums[i]);
                i--;
            }
        }

        // find the first num larger than min from left to right
        int left = 0;
        for (; left < nums.length; left++) {
            if (nums[left] > min) {
                break;
            }
        }

        // find the first num smaller than max from right to left
        int right = nums.length - 1;
        for (; right >= 0; right--) {
            if (nums[right] < max) {
                break;
            }
        }

        return right <= left ? 0
                             : right - left + 1;
    }
}