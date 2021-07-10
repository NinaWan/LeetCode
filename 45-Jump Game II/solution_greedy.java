class Solution {
    public int jump(int[] nums) {
        int n = nums.length, ans = 0;
        int end = 0, farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i) {
                end = farthest;
                ans++;
            }
        }

        return ans;
    }
}