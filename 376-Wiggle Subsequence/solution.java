class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n], neg = new int[n];
        pos[0] = 1;
        neg[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {// positive difference
                pos[i] = neg[i - 1] + 1;
                neg[i] = neg[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                pos[i] = pos[i - 1];
                neg[i] = pos[i - 1] + 1;
            } else {
                pos[i] = pos[i - 1];
                neg[i] = neg[i - 1];
            }
        }

        return Math.max(pos[n - 1], neg[n - 1]);
    }
}