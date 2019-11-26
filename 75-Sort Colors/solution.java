class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int ph = 0;
        int pt = nums.length - 1;
        int curr = 0;

        while (ph < pt && curr <= pt && curr >= ph) {
            if (nums[curr] == 1) {
                curr++;
                continue;
            }

            if (nums[curr] == 0) {
                nums[curr] = nums[ph];
                nums[ph] = 0;
                if (curr == ph) {
                    curr++;
                }
                ph++;
            } else {
                nums[curr] = nums[pt];
                nums[pt] = 2;
                pt--;
            }
        }
    }
}