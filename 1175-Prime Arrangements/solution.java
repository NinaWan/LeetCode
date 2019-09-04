class Solution {
    public int numPrimeArrangements(int n) {
        int primeNum = countPrimes(n);
        int nonPrimeNum = n - primeNum;
        long result = 1;
        int mod = (int) Math.pow(10, 9) + 7;

        for (int i = 2; i <= primeNum; i++) {
            result *= i;
            if (result > mod) {
                result = result % mod;
            }
        }

        for (int j = 2; j <= nonPrimeNum; j++) {
            result *= j;
            if (result > mod) {
                result = result % mod;
            }
        }

        return (int) result;
    }

    private int countPrimes(int n) {
        int result = 0;

        for (int current = 1; current <= n; current++) {
            if (isPrime(current)) {
                result++;
            }
        }

        return result;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}