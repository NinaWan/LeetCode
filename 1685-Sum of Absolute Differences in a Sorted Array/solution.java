class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] sufix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = i * (nums[i] - nums[i - 1]) + prefix[i - 1];
            sufix[n - i - 1] = i * (nums[n - i] - nums[n - i - 1]) + sufix[n - i];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] + sufix[i];
        }

        return result;
    }
}