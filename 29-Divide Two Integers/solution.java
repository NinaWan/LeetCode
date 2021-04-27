class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {// overflow
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            return -dividend;
        }

        int ans = 0;
        long minuend = Math.abs((long) dividend);
        long subtractor = Math.abs((long) divisor);
        while (minuend >= subtractor) {
            minuend -= subtractor;
            ans++;
        }

        return (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -ans
                                                                              : ans;
    }
}