class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int occurrence = 0;
        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[length] = nums[i];
                occurrence = 1;
                length++;
                continue;
            }

            if (occurrence < 2) {
                occurrence++;
                nums[length] = nums[i];
                length++;
            }
        }

        return length;
    }
}