class Solution {
    public boolean checkPowersOfThree(int n) {
        int quotient = n;

        while (quotient != 0) {
            if (quotient % 3 == 2) {
                return false;
            }
            quotient /= 3;
        }

        return true;
    }
}