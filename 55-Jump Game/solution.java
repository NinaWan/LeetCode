class Solution {
    public boolean canJump(int[] nums) {
        if (null == nums || nums.length == 0) {
            return true;
        }

        int[] maxReaches = new int[nums.length];
        int currentMaxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentMaxReach < i) {
                return false;
            }

            maxReaches[i] = nums[i] + i;
            currentMaxReach = Math.max(maxReaches[i], currentMaxReach);

            if (currentMaxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}