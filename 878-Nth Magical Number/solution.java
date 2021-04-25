class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = (int) 1e9 + 7;
        int lcm = a / gcd(a, b) * b;
        int m = lcm / a + lcm / b - 1;
        int q = n / m, r = n % m;

        long ans = (long) q * lcm % mod;
        if (r == 0) {
            return (int) ans;
        }

        int y1 = a, y2 = b;
        for (int i = 1; i < r; i++) {
            if (y1 < y2) {
                y1 += a;
            } else {// r<m, y1 won't equal y2
                y2 += b;
            }
        }

        ans += Math.min(y1, y2);

        return (int) (ans % mod);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a
                      : gcd(b, a % b);
    }
}