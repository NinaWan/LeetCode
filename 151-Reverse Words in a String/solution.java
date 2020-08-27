class Solution {
    public String reverseWords(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }

        String result = "";
        for (String word : s.trim().split(" ")) {
            String curr = word.trim();
            if ("".equals(curr)) {
                continue;
            }
            result = curr + " " + result;
        }

        return result.trim();
    }
}