class Solution {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int[] lises = new int[nums.length];
        int result = 0;
        Arrays.fill(lises, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lises[i] = Math.max(lises[i], lises[j] + 1);
                }
            }
            result = Math.max(result, lises[i]);
        }

        return result;
    }
}