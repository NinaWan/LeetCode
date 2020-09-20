class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i + 1);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int j = 0;
            int n = Math.min(word1.length(), word2.length());
            for (; j < n; j++) {
                if (word1.charAt(j) == word2.charAt(j)) {
                    continue;
                }

                int order1 = map.get(word1.charAt(j));
                int order2 = map.get(word2.charAt(j));
                if (order1 > order2) {
                    return false;
                } else {
                    break;
                }
            }
            if (j == n && word2.length() < word1.length()) {
                return false;
            }
        }

        return true;
    }
}