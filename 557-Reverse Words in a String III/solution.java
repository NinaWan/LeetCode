public class Solution {
    public String reverseWords(String s) {
        if (null == s || 0 == s.length())
            return s;

        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            result.append(reverse(word) + " ");
        }

        return result.toString().trim();
    }

    private String reverse(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }
}