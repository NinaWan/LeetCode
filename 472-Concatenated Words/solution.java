class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList();
        Set<String> preWords = new HashSet();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            if (wordBreak(word, preWords)) {
                ans.add(word);
            }
            preWords.add(word);
        }

        return ans;
    }

    private boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.isEmpty()) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}