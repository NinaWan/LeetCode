class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int result = 0;
        Arrays.sort(nums);

        for (int left = 0; left < nums.length; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }

            for (int right = left + 1; right < nums.length; right++) {
                if (nums[right] - nums[left] > k) {
                    break;
                } else if (nums[right] - nums[left] == k) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}