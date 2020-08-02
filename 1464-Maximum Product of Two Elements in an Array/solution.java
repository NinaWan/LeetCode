class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[2];
        max[0] = Math.max(nums[0], nums[1]);
        max[1] = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= max[0]) {
                max[1] = max[0];
                max[0] = nums[i];
            } else if (nums[i] > max[1]) {
                max[1] = nums[i];
            }
        }

        return (max[0] - 1) * (max[1] - 1);
    }
}