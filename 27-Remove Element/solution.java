public class Solution {
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) return 0;

        int count = 0;
        int oriLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            // move not-equal values forward
            if (nums[i] != val) {
                count += 1;
                for (int j = i; j > 0; j--) {
                    if (j > 0 && nums[j - 1] == val) {
                        nums[j - 1] = nums[j];
                        nums[j] = val;
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }
}