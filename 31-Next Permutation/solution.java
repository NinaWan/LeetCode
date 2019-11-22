class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = i; j < nums.length; j++) {
                    if (j == nums.length - 1 || (nums[j] > nums[i - 1] && nums[j + 1] <= nums[i - 1])) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                break;
            }
        }

        for (int m = i, n = nums.length - 1; m < n; m++, n--) {
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
        }
    }
}