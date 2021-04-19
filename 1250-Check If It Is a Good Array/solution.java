class Solution {
    public boolean isGoodArray(int[] nums) {
        int ans = nums[0];

        for (int num : nums) {
            ans = gcd(ans, num);
        }

        return ans == 1;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }
}