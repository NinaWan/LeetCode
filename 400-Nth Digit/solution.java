public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;

        int m = 2;
        long left = (long) ((9 * m - 1) * Math.pow(10, m) + 1) / 9;
        while (left < n) {
            m++;
            left = (long) ((9 * m - 1) * Math.pow(10, m) + 1) / 9;
        }

        if (left == n) return 9;
        left = (long) ((9 * (m - 1) - 1) * Math.pow(10, m - 1) + 1) / 9;

        int quotient = (int) (n - left) / m;
        int remainder = (int) (n - left) % m;
        int number = (int) (Math.pow(10, m - 1) + quotient - 1);

        Integer result = null;
        if (remainder == 0) {
            String s = String.valueOf(number);
            String num = String.valueOf(s.charAt(s.length() - 1));
            result = Integer.valueOf(num);
        } else {
            number += 1;
            String s = String.valueOf(number);
            String num = String.valueOf(s.charAt(remainder - 1));
            result = Integer.valueOf(num);
        }
        return result;
    }
}