class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3) {
            return true;
        }

        int fallingPoint = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (fallingPoint != -1) {
                    return false;
                }

                fallingPoint = i;
            }
        }

        return fallingPoint <= 0 || fallingPoint >= nums.length - 2 || fallingPoint == -1 || nums[fallingPoint + 1] >= nums[fallingPoint - 1] ||
                nums[fallingPoint] <= nums[fallingPoint + 2];
    }
}