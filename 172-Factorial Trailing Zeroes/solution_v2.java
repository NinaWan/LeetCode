class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;

        for (int d = n; d / 5 > 0; d /= 5) {
            ans += d / 5;
        }

        return ans;
    }
}