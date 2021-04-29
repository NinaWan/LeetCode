class Solution {
    public int makeStringSorted(String s) {
        int n = s.length();
        int mod = (int) 1e9 + 7;
        long ans = 1;
        int[] count = new int[26];
        long[] factorial = new long[3001], inverseModulo = new long[3001];
        factorial[0] = 1;
        inverseModulo[0] = 1;

        for (int i = 1; i < 3001; i++) {
            factorial[i] = i * factorial[i - 1] % mod;
            inverseModulo[i] = modPow(factorial[i], mod - 2, mod);
        }

        for (int i = n - 1; i >= 0; i--) {// for each letter from right to left, fixed prefix
            int idx = s.charAt(i) - 'a';
            count[idx]++;

            int sum = 0;
            for (int j = 0; j < idx; j++) {
                sum += count[j];
            }

            long permutation = sum * factorial[n - i - 1] % mod;
            for (int c : count) {
                permutation = permutation * inverseModulo[c] % mod;
            }

            ans = (ans + permutation) % mod;
        }

        return (int) ans - 1;
    }

    private long modPow(long base, int exponent, int modulus) {
        if (exponent == 0) {
            return 1;
        }

        long b = modPow(base, exponent / 2, modulus) % modulus;
        long pow = b * b % modulus;

        return exponent % 2 == 1 ? pow * base % modulus
                                 : pow;
    }
}