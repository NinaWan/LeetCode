class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, sum = 0, n = nums.length;
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && sum < target) {
                sum += nums[j];
                j++;
            }

            while (i < j && sum >= target) {
                ans = Math.min(ans, j - i);
                sum -= nums[i];
                i++;
            }
        }

        return i == 0 && j == n && sum < target ? 0
                                                : ans;
    }
}