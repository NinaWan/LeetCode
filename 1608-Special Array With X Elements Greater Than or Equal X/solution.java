class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int p = 0;
        for (int x = 1; x <= nums.length; x++) {
            while (p < nums.length && nums[p] < x) {
                p++;
            }

            if (nums.length - p == x) {
                return x;
            }
        }

        return -1;
    }
}