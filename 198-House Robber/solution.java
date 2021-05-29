class Solution {
    public int rob(int[] nums) {
        int ans = 0, prev1 = 0, prev2 = 0;

        for (int num : nums) {
            ans = Math.max(num + prev2, prev1);// rob or not rob
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }
}