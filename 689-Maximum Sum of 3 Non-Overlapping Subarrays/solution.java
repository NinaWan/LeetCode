class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums.length <= 3) {
            return nums.length == 3 ? new int[]{0, 1, 2} : new int[0];
        }

        // calculate sum for each possile interval with length k
        int[] kSum = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                kSum[i - k + 1] = sum;
            }
        }

        int[] leftDp = new int[kSum.length];
        leftDp[0] = 0;
        for (int i = 1; i < kSum.length; i++) {
            leftDp[i] = kSum[i] > kSum[leftDp[i - 1]] ? i : leftDp[i - 1];
        }

        int[] rightDp = new int[kSum.length];
        rightDp[kSum.length - 1] = kSum.length - 1;
        for (int i = kSum.length - 2; i >= 0; i--) {
            rightDp[i] = kSum[i] >= kSum[rightDp[i + 1]] ? i : rightDp[i + 1];
        }

        int[] result = new int[]{-1, -1, -1};
        for (int i = k; i < kSum.length - k; i++) {
            int left = leftDp[i - k], right = rightDp[i + k];
            if (result[0] == -1 || kSum[left] + kSum[i] + kSum[right] > kSum[result[0]] + kSum[result[1]] + kSum[result[2]]) {
                result[0] = left;
                result[1] = i;
                result[2] = right;
            }
        }

        return result;
    }
}