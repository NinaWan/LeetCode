class Solution {
    public int countPrimes(int n) {
        int result = 0;

        for (int current = 1; current < n; current++) {
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