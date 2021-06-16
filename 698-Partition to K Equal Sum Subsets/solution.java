class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        return canPartitionKSubsets(nums, k, sum / k, 0, 0, new boolean[nums.length]);
    }

    private boolean canPartitionKSubsets(int[] nums, int k, int target, int curr, int pos, boolean[] visited) {
        if (k == 0) {
            return true;
        }

        if (curr == target) {
            return canPartitionKSubsets(nums, k - 1, target, 0, 0, visited);
        }

        for (int i = pos; i < nums.length; i++) {
            if (!visited[i] && nums[i] + curr <= target) {
                visited[i] = true;
                if (canPartitionKSubsets(nums, k, target, curr + nums[i], i + 1, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
}