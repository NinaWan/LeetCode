class Solution {
    public int primePalindrome(int N) {
        if (N >= 8 && N <= 11) {
            return 11;
        }

        for (int i = 1; i < 100000; i++) {
            int palindrome = Integer.valueOf(i + new StringBuilder(String.valueOf(i)).reverse().substring(1).toString());
            if (palindrome >= N && isPrime(palindrome)) {
                return palindrome;
            }
        }

        return 0;
    }

    private boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }

        if (num == 1 || num % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}