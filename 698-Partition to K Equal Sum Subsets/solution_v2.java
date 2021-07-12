class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        return backtrack(nums, 0, sum / k, new int[k]);
    }

    private boolean backtrack(int[] nums, int pos, int target, int[] bucket) {
        if (pos == nums.length) {
            for (int b : bucket) {
                if (b != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (nums[pos] + bucket[i] > target) {
                continue;
            }

            bucket[i] += nums[pos];
            if (backtrack(nums, pos + 1, target, bucket)) {
                return true;
            }
            bucket[i] -= nums[pos];
        }

        return false;
    }
}