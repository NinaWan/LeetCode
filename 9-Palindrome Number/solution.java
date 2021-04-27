public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int quotient = x;
        int reverse = 0;

        while (quotient != 0) {
            reverse = reverse * 10 + quotient % 10;
            quotient = quotient / 10;
        }

        if (reverse == x)
            return true;
        return false;
    }
}