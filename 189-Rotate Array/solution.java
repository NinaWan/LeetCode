public class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        int[] temp = new int[nums.length];
        int step = k % nums.length;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        for (int i = nums.length - step; i < nums.length; i++) {
            index++;
            nums[index] = temp[i];
        }

        if (index < nums.length - 1) {
            for (int i = 0; i < nums.length - step; i++) {
                index++;
                nums[index] = temp[i];
            }
        }
    }
}