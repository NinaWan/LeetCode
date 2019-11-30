class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Integer result = null;
        int left = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s && left <= i) {
                result = result == null ? i - left + 1 : Math.min(result, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return result == null ? 0 : result;
    }
}