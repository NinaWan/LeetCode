public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int length = s.length();

        if (null != s && !s.isEmpty()) {
            if (length == 1) {
                result = s.charAt(0) - 64;
            } else {
                for (int i = length - 1; i > 0; i--) {
                    result += (int) Math.pow(26, i);
                }

                for (int i = 0; i < length - 1; i++) {
                    char currentChar = s.charAt(i);
                    result += (int) (currentChar - 65) * Math.pow(26, length - i - 1);
                }
                result += s.charAt(length - 1) - 64;
            }
        }
        return result;
    }
}