class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 2; j < preSum.length; j++) {
                if ((k == 0 && preSum[j] == preSum[i]) || (k != 0 && (preSum[j] - preSum[i]) % k == 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}