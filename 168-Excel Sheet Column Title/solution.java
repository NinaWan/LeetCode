class Solution {
    public String convertToTitle(int n) {
        String result = "";
        int quotient = n;
        while (quotient != 0) {
            int remainder = (quotient - 1) % 26;
            result = (char) ('A' + remainder) + result;
            quotient = (quotient - 1) / 26;
        }
        return result;
    }
}