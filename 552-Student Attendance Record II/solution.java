class Solution {
    public int checkRecord(int n) {
        int mod = (int) 1e9 + 7;
        long[] pl = new long[n + 1]; // pl[i] - ending at P or L without A for length i
        long[] p = new long[n + 1]; // p[i] - ending at P without A for length i
        p[0] = p[1] = pl[0] = 1;
        pl[1] = 2;

        for (int i = 2; i <= n; i++) {
            p[i] = pl[i - 1];
            pl[i] = (p[i] + p[i - 1] + p[i - 2]) % mod;
        }

        long ans = pl[n];
        for (int i = 0; i < n; i++) {// insert A into n-1 length strings
            ans = (ans + (pl[i] * pl[n - 1 - i] % mod)) % mod;
        }

        return (int) ans;
    }
}