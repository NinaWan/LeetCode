class Solution {
    public int longestStrChain(String[] words) {
        int ans = 1;
        Map<String, Integer> lsc = new HashMap();
        TreeSet<String> set = new TreeSet<String>((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });

        for (String word : words) {
            set.add(word);
        }

        for (String word : set) {
            if (word.length() == 1) {
                break;
            }

            lsc.putIfAbsent(word, 1);

            for (int i = 0; i < word.length(); i++) {
                String curr = "";
                if (i == 0) {
                    curr = word.substring(i + 1, word.length());
                } else if (i == word.length() - 1) {
                    curr = word.substring(0, i);
                } else {
                    curr = word.substring(0, i) + word.substring(i + 1, word.length());
                }

                if (set.contains(curr)) {
                    lsc.put(curr, Math.max(lsc.getOrDefault(curr, 0), lsc.get(word) + 1));
                    ans = Math.max(ans, lsc.get(curr));
                }
            }
        }

        return ans;
    }
}