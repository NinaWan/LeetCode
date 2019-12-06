class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int curr = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                max = Math.max(max, curr);
                curr = 1;
            } else {
                curr++;
            }
        }

        return Math.max(max, curr);
    }
}