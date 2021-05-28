class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet(wordDict), new HashMap<String, List<String>>());
    }

    private List<String> dfs(String s, Set<String> words, Map<String, List<String>> map) {
        List<String> res = new ArrayList();

        if (s.length() == 0) {
            res.add("");
            return res;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (String word : words) {
            if (s.startsWith(word)) {
                List<String> wordBreaks = dfs(s.substring(word.length()), words, map);
                for (String wordBreak : wordBreaks) {
                    res.add(word + (wordBreak.equals("") ? ""
                                                         : " " + wordBreak));
                }
            }
        }

        map.put(s, res);

        return res;
    }
}