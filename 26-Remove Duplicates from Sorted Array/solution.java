class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int result = 1;
        int temp;
        int currIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[result] > nums[currIndex]) {
                result++;
                currIndex++;
            } else {
                for (int j = result; j < nums.length - 1; j++) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return result;
    }
}