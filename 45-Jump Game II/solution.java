class Solution {
    public int jump(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int currentMaxReach = 0;
        int stepNum = 0;
        int index = 0;

        while (currentMaxReach < nums.length - 1) {
            stepNum++;
            int temp = currentMaxReach;

            for (; index <= temp; index++) {
                currentMaxReach = Math.max(nums[index] + index, currentMaxReach);
            }
        }

        return stepNum;
    }
}