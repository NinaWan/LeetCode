class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                dup = idx + 1;
            } else {
                nums[idx] = -nums[idx];
            }
        }

        int missing = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[] {dup, missing};
    }
}