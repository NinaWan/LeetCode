class Solution {
    public int numPrimeArrangements(int n) {
        long ans = 1;
        int primeCount = countPrimes(n);
        for (int i = primeCount; i > 1; i--) {
            ans *= i;
            ans %= 1e9 + 7;
        }

        for (int i = 2; i <= n - primeCount; i++) {
            ans *= i;
            ans %= 1e9 + 7;
        }

        return (int) ans;
    }

    private int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int ans = 0;

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < Math.sqrt(n + 1); i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < n + 1; j += i) {
                isPrime[j] = false;
            }
        }

        for (boolean e : isPrime) {
            ans += e ? 1 : 0;
        }

        return ans;
    }
}