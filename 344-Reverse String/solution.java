public class Solution {
    public String reverseString(String s) {
        if (null == s || s.length() < 2) return s;

        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}