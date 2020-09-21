class Solution {
    public int reverse(int x) {
        long ans = 0;

        long quotient = Math.abs((long) x);
        while (quotient != 0) {
            ans = ans * 10 + quotient % 10;
            quotient = quotient / 10;
        }

        if (x < 0) {
            ans = -ans;
        }

        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) ans;
    }
}