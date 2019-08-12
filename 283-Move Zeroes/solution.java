public class Solution {
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length < 2) return;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                // move non-zeros forward
                for (int j = i; j > 0; j--) {
                    if (nums[j - 1] == 0) {
                        nums[j - 1] = nums[j];
                        nums[j] = 0;
                    }
                }
            }
        }
    }
}