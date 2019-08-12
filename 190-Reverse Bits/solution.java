public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;

        long quotient;
        String result = "";
        long resultL = 0;

        if (n < 0) {
            quotient = Integer.MAX_VALUE + (long) Math.pow(2, 31) + 1 + n;
        } else {
            quotient = n;
        }

        while (quotient != 0) {
            result += quotient % 2;
            quotient = quotient / 2;
        }

        for (int i = result.length() + 1; i < 33; i++) {
            result += '0';
        }

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(result.length() - 1 - i) == '1') {
                resultL += Math.pow(2, i);
            }
        }

        return Integer.parseUnsignedInt(String.valueOf(resultL));
    }
}