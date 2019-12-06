class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        double max = (double) currSum / k;

        for (int i = 0; i < nums.length - k; i++) {
            currSum = currSum - nums[i] + nums[i + k];
            max = Math.max(max, (double) currSum / k);
        }

        return max;
    }
}