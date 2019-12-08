class Solution {
    public int dominantIndex(int[] nums) {
        int first = -1;
        int second = -1;
        for (int i = 0; i < nums.length; i++) {
            if (first == -1 || nums[i] > nums[first]) {
                second = first;
                first = i;
            }

            if (nums[i] < nums[first] && (second == -1 || nums[i] > nums[second])) {
                second = i;
            }
        }

        return second == -1 || nums[first] >= nums[second] * 2 ? first : -1;
    }
}