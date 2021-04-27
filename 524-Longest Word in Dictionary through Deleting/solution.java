class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        Collections.sort(d);

        for (String word : d) {
            if (word.length() > s.length()) {
                break;
            }

            if (isPossible(s, word) && word.length() > ans.length()) {
                ans = word;
            }
        }

        return ans;
    }

    private boolean isPossible(String s, String word) {
        int i = 0, j = 0;
        for (; i < s.length() && j < word.length();) {
            if (s.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == word.length();
    }
}