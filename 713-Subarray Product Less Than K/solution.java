class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }

        int leftIdx = 0, rightIdx = 0;
        int result = 0;
        int product = 1;
        for (; rightIdx < nums.length; rightIdx++) {
            product *= nums[rightIdx];
            while (product >= k) {
                product /= nums[leftIdx];
                leftIdx++;
            }
            result += rightIdx - leftIdx + 1;
        }

        return result;
    }
}