class Solution {
    public int integerReplacement(int n) {
        int ans = 0;
        if (n == Integer.MAX_VALUE) {
            return 32;
        }

        while (n > 1) {
            if (n % 2 == 0) {// n is even
                n = n / 2;
            } else {// n is odd
                if (n == 3 || (n - 1) % 4 == 0) {
                    n--;
                } else {
                    n++;
                }
            }
            ans++;
        }

        return ans;
    }
}