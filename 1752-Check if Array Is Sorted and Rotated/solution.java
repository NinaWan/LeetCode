class Solution {
    public boolean check(int[] nums) {
        int min = nums[0];
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }

            if (count > 1) {
                return false;
            }

            if (count > 0 && nums[i] > min) {
                return false;
            }
        }

        return true;
    }
}