class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        String extraA = "a";
        String ans = "";

        for (String word : words) {
            String first = word.substring(0, 1);
            if ("aeiouAEIOU".contains(first) || word.length() == 1) {
                ans += word + "ma";
            } else {
                ans += word.substring(1, word.length()) + first + "ma";
            }

            ans += extraA + " ";
            extraA += "a";
        }

        return ans.trim();
    }
}