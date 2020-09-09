class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int ans = 0;

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        for (boolean e : isPrime) {
            ans += e ? 1 : 0;
        }

        return ans;
    }
}