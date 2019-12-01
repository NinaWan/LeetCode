class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                sum *= nums[i - 1];
                result[i] = sum;
            }
        }

        sum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1) {
                sum *= nums[i + 1];
                result[i] = sum * result[i];
            }
        }

        return result;
    }
}