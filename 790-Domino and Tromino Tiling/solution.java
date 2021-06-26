class Solution {
    public int numTilings(int n) {
        int mod = (int) 1e9 + 7;

        int p1 = 1, p2 = 0, p3 = -1;// dp[0], dp[-1], dp[-2]
        for (int i = 1; i <= n; i++) {
            // dp[n] = 2*dp[n-1]+dp[n-3]
            int curr = (int) ((p1 * 2l + p3) % mod);
            p3 = p2;
            p2 = p1;
            p1 = curr;
        }

        return p1;
    }
}