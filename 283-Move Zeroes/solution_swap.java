class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int right = i + 1;
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }

                if (right == nums.length) {
                    return;
                }

                nums[i] = nums[right];
                nums[right] = 0;
            }
        }
    }
}