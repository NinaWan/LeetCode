class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int pos, int sum) {
        if (pos == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        return findTargetSumWays(nums, target, pos + 1, sum + nums[pos]) + findTargetSumWays(nums, target, pos + 1, sum - nums[pos]);
    }
}