public class Solution {
    public String addStrings(String num1, String num2) {
        if (null == num1 || null == num2) return null;
        if (0 == num1.length() || 0 == num2.length()) return 0 == num1.length() ? num2 : num1;

        char[] result = new char[(num1.length() > num2.length() ? num1.length() : num2.length()) + 1];
        String resultStr = "";

        for (int i = 1; i < result.length; i++) {
            result[i] = '0';
        }

        for (int i = num1.length() - 1, j = num2.length() - 1, k = result.length - 1; i > -1 || j > -1 || k > 0; i--, j--, k--) {
            int digit1 = 0;
            int digit2 = 0;
            int digit3 = 0;

            if (i > -1) digit1 = num1.charAt(i) - '0';
            if (j > -1) digit2 = num2.charAt(j) - '0';
            digit3 = result[k] - '0';

            if (digit1 + digit2 + digit3 > 9) {
                result[k] = (char) ((digit1 + digit2 + digit3) % 10 + 48);
                result[k - 1] = (char) 49;
            } else {
                result[k] = (char) (digit1 + digit2 + digit3 + 48);
            }
        }

        for (char c : result) {
            if (c > 47 && c < 58) resultStr += c;
        }
        return resultStr;
    }
}