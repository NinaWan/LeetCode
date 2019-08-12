public class Solution {
    public boolean isUgly(int num) {
        if (num == 1) return true;
        if (num <= 0) return false;

        int remainder = 0;
        int quotient = num;

        while (quotient != 1) {
            if (quotient % 2 == 0) {
                quotient = quotient / 2;
            } else {
                if (quotient % 3 == 0) {
                    quotient = quotient / 3;
                } else {
                    if (quotient % 5 == 0) {
                        quotient = quotient / 5;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}