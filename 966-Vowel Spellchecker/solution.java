class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];
        Set<String> matched = new HashSet();
        Map<String, String> capMatched = new HashMap();
        Map<String, String> vowelMatched = new HashMap();

        for (String word : wordlist) {
            matched.add(word);
            capMatched.putIfAbsent(word.toLowerCase(), word);
            vowelMatched.putIfAbsent(word.toLowerCase().replaceAll("[aiueo]", "-"), word);
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            String lowerQ = query.toLowerCase();
            String proQ = lowerQ.replaceAll("[aiueo]", "-");

            if (matched.contains(query)) {
                ans[i] = query;
                continue;
            }

            if (capMatched.containsKey(lowerQ)) {
                ans[i] = capMatched.get(lowerQ);
                continue;
            }

            if (vowelMatched.containsKey(proQ)) {
                ans[i] = vowelMatched.get(proQ);
                continue;
            }

            ans[i] = "";
        }

        return ans;
    }
}