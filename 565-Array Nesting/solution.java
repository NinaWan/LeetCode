class Solution {
    public int arrayNesting(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int nextIdx = nums[i];
            int count = 1;

            if (nums[i] < 0) {
                continue;
            }

            while (nums[nextIdx] != nums[i]) {
                int temp = nums[nextIdx];
                nums[nextIdx] = -1;
                nextIdx = temp;
                count++;
            }

            nums[i] = -1;

            result = Math.max(result, count);
        }

        return result;
    }
}