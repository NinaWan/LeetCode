class Solution {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1, 1337);
    }

    private int superPow(int a, int[] b, int i, int mod) {
        if (i < 0) {
            return 1;
        }

        int part1 = pow(a, b[i], mod);
        int part2 = pow(superPow(a, b, i - 1, mod), 10, mod);

        return (part1 * part2) % mod;
    }

    private int pow(int base, int exponent, int mod) {
        base %= mod;

        int res = 1;
        for (int i = 0; i < exponent; i++) {
            res *= base;
            res %= mod;
        }

        return res;
    }
}