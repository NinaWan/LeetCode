class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet();

        Arrays.sort(words, (w1, w2) -> {
            return w1.length() - w2.length();
        });
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].indexOf(words[i]) != -1) {
                    result.add(words[i]);
                }
            }
        }

        return new ArrayList(result);
    }
}