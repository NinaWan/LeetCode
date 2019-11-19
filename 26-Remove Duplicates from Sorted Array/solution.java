class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {
                continue;
            }

            if (index + 1 <= i) {
                nums[index + 1] = nums[i];
                index++;
            }
        }

        return index + 1;
    }
}