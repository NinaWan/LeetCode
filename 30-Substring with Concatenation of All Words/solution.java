class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList();

        if (words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
            return result;
        }

        Map<String, Integer> expected = new HashMap();
        for (String word : words) {
            expected.put(word, expected.getOrDefault(word, 0) + 1);
        }

        int wl = words[0].length();
        for (int i = 0; i <= s.length() - words.length * wl; i++) {// each position in s
            Map<String, Integer> current = new HashMap();
            for (int j = 0; j < words.length; j++) {// each word in word list
                String str = s.substring(i + j * wl, i + (j + 1) * wl);
                if (!expected.containsKey(str)) {
                    break;
                }

                current.put(str, current.getOrDefault(str, 0) + 1);
                if (current.get(str) > expected.get(str)) {
                    break;
                }

                if (j == words.length - 1) {
                    result.add(i);
                }
            }
        }

        return result;
    }
}