class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int subsum = 0;
        int sum = 0;
        int l = -1;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && subsum + x < sum) {
                subsum += nums[j];
                j++;
            }

            if (subsum + x == sum) {
                l = Math.max(l, j - i);
            }

            subsum -= nums[i];
        }

        return l == -1 ? -1
                       : n - l;
    }
}