class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        for (int i = 0, j = -1; i < n; i++) {
            result[++j] = nums[i];
            result[++j] = nums[i + n];
        }

        return result;
    }
}