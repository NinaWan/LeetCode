class Solution {
    public boolean checkZeroOnes(String s) {
        int countOne = 0, countZero = 0, n = s.length();
        for (int i = 0; i < n;) {
            int one = 0, zero = 0;
            while (i < n && s.charAt(i) == '1') {
                one++;
                i++;
            }
            countOne = Math.max(countOne, one);
            while (i < n && s.charAt(i) == '0') {
                zero++;
                i++;
            }
            countZero = Math.max(countZero, zero);
        }

        return countOne > countZero;
    }
}