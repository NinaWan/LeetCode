class Solution {
    public int waysToSplit(int[] nums) {
        long ans = 0;
        int n = nums.length, mod = (int) 1e9 + 7;
        int[] preSum = new int[n];
        preSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        // i - last element in first subarray
        // l - leftmost last element in second subarray
        // r - rightmost last element in second subarray, but after the second loop will get an additional one for r since the
        // condition is to find the first element breaks the rule, instead of the last element meets the rule
        for (int i = 0, l = 0, r = 0; i < n - 2; i++) {
            while (l <= i || (l < n - 1 && preSum[l] < 2 * preSum[i])) {
                l++;
            }

            while (r < l || (r < n - 1 && preSum[n - 1] - preSum[r] >= preSum[r] - preSum[i])) {
                r++;
            }

            ans = (ans + r - l) % mod;
        }

        return (int) ans;
    }
}