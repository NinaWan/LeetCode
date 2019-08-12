public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        long quotient;
        if (n < 0) {
            quotient = Integer.MAX_VALUE + (long) Math.pow(2, 31) + 1 + n;
        } else {
            quotient = n;
        }
        while (quotient != 0) {
            if (quotient % 2 == 1) count++;
            quotient = quotient / 2;
        }
        return count;
    }
}