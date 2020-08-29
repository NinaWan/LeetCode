class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String ans = "";

        for (String word : s.split(" ")) {
            String reversedWord = "";
            for (char c : word.toCharArray()) {
                reversedWord = Character.toString(c) + reversedWord;
            }

            ans += reversedWord + " ";
        }

        return ans.trim();
    }
}