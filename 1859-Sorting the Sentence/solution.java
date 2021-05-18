class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] origWords = new String[words.length];
        for (String word : words) {
            int l = word.length();
            origWords[word.charAt(l - 1) - '0' - 1] = word.substring(0, l - 1);
        }

        StringBuilder ans = new StringBuilder();
        for (String word : origWords) {
            ans.append(word + " ");
        }

        return ans.toString().trim();
    }
}