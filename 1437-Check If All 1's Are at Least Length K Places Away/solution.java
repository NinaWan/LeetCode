class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        boolean result = true;

        int p = 0;
        while (p < nums.length && result) {
            if (nums[p] == 1) {
                p += 1;
                for (int i = 0; i < k && p < nums.length; i++) {
                    if (nums[p] == 1) {
                        result = false;
                        break;
                    }
                    p++;
                }
            } else {
                p++;
            }
        }

        return result;
    }
}