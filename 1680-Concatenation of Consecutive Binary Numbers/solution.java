class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int bitLength = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            ans = ((ans << bitLength) + i) % mod;
        }

        return (int) ans;
    }
}