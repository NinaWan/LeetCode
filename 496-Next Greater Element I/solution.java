public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        if (findNums.length > nums.length) return result;

        for (int i = 0; i < findNums.length; i++) {
            int j = 0;
            // Find the position first
            for (; j < nums.length; j++) {
                if (findNums[i] == nums[j]) break;
            }

            for (; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    result[i] = nums[j];
                    break;
                }
            }
            if (j > nums.length - 1) result[i] = -1;
        }

        return result;
    }
}