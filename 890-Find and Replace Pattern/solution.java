class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList();

        for (String word : words) {
            Map<Character, Character> w2p = new HashMap();
            Map<Character, Character> p2w = new HashMap();
            boolean isMatched = true;
            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                if ((w2p.containsKey(w) && w2p.get(w) != p) || (p2w.containsKey(p) && p2w.get(p) != w)) {
                    isMatched = false;
                    break;
                }

                w2p.put(w, p);
                p2w.put(p, w);
            }

            if (isMatched) {
                result.add(word);
            }
        }

        return result;
    }
}