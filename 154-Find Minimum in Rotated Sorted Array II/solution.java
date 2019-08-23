class Solution {
    public int findMin(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }

        return nums[0];
    }
}