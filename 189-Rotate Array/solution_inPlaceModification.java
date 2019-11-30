class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k % nums.length == 0) {
            return;
        }

        int moveStart = nums.length - k % nums.length;

        // reverse elements before moveStart
        reverse(nums, 0, moveStart - 1);

        // reverse elements after(including) moveStart
        reverse(nums, moveStart, nums.length - 1);

        // reverse elements in the whole array
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}