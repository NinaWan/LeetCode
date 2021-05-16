class Solution {
    public int maxSumMinProduct(int[] nums) {
        long ans = 0;
        int n = nums.length, mod = (int) 1e9 + 7;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        Stack<Integer> stack = new Stack();
        for (int j = 0; j <= n; j++) {
            while (!stack.isEmpty() && (j == n || nums[stack.peek()] > nums[j])) {
                int i = stack.pop();
                // e.g [0,2,4], j=7, i=4, nums[7]>nums[4]>nums[2].
                // let nums[4] as the minimum value, the min-product should be nums[4]*(preSum[7]-preSum(3)), which is nums[4]*sum of
                // nums[3, 7)
                ans = Math.max(ans, nums[i] * (preSum[j] - preSum[stack.isEmpty() ? 0
                                                                                  : stack.peek() + 1]));
            }
            stack.push(j);
        }

        return (int) (ans % mod);
    }
}