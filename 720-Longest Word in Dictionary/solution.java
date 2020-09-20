class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet();
        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            String substring = "";
            boolean isValid = true;
            for (int i = 0; i < word.length(); i++) {
                substring += String.valueOf(word.charAt(i));
                if (!set.contains(substring)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid && (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0))) {
                ans = word;
            }
        }

        return ans;
    }
}