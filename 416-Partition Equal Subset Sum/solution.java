class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return canPartition(nums, sum, 0, 0, new Boolean[sum + 1][nums.length + 1]);
    }

    private boolean canPartition(int[] nums, int sum, int currSum, int pos, Boolean[][] cache) {
        if (2 * currSum == sum) {
            return true;
        }

        if (cache[currSum][pos] != null) {
            return cache[currSum][pos];
        }

        if ((pos < nums.length && 2 * currSum > sum) || pos == nums.length) {
            return false;
        }

        for (int i = pos; i < nums.length; i++) {
            if (canPartition(nums, sum, currSum, i + 1, cache) || canPartition(nums, sum, currSum + nums[i], i + 1, cache)) {
                cache[currSum][i] = true;
                return true;
            }
            cache[currSum][i] = false;
        }

        return false;
    }
}