class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i == 0 ? nums[0]
                             : nums[i - 1] + nums[i];
        }

        for (int left = -1; left < nums.length; left++) {
            for (int right = left + 1; right < nums.length; right++) {
                int sum = left == -1 ? nums[right]
                                     : nums[right] - nums[left];
                if (sum == k) {
                    result++;
                }
            }
        }

        return result;
    }
}