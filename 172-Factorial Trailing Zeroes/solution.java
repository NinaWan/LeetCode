class Solution {
    public int trailingZeroes(int n) {
        int numOfFive = 0;
        int quotient = n / 5;

        while (quotient != 0) {
            numOfFive += quotient;
            quotient = quotient / 5;
        }

        return numOfFive;
    }
}