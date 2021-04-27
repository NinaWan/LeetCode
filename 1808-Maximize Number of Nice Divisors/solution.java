class Solution {
    public int maxNiceDivisors(int primeFactors) {
        int mod = (int) 1e9 + 7;
        if (primeFactors <= 3) {
            return primeFactors;
        } else if (primeFactors % 3 == 0) {// only 3
            return (int) modPow(3, primeFactors / 3, mod);
        } else if (primeFactors % 3 == 1) {// 3 and two 2
            return (int) (modPow(3, (primeFactors - 4) / 3, mod) * 4 % mod);
        }

        return (int) (modPow(3, (primeFactors - 2) / 3, mod) * 2 % mod);// 3 and one 2
    }

    private long modPow(long base, int exponent, int modulus) {
        long res = 1;

        for (; exponent > 0; exponent /= 2) {
            if (exponent % 2 == 1) {
                res = res * base % modulus;
            }
            base = base * base % modulus;
        }

        return res;
    }
}