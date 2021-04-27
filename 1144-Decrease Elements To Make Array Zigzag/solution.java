class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int evenDesc = 0;
        int oddDesc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenDesc += Math.max(0, nums[i] - Math.min(i == 0 ? Integer.MAX_VALUE
                                                                  : nums[i - 1],
                        i == nums.length - 1 ? Integer.MAX_VALUE
                                             : nums[i + 1]) +
                        1);
            } else {
                oddDesc += Math.max(0, nums[i] - Math.min(nums[i - 1], i == nums.length - 1 ? Integer.MAX_VALUE
                                                                                            : nums[i + 1]) +
                        1);
            }
        }

        return Math.min(evenDesc, oddDesc);
    }
}