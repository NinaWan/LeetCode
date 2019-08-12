public class Solution {
    public String convertToBase7(int num) {
        long abs = Math.abs(num);

        String result = "";
        int quotient = (int) (abs / 7);
        int remainder = (int) (abs % 7);
        result = String.valueOf(remainder) + result;

        while (quotient != 0) {
            remainder = quotient % 7;
            result = String.valueOf(remainder) + result;
            quotient = quotient / 7;
        }

        if (num < 0) result = "-" + result;
        return result;
    }
}