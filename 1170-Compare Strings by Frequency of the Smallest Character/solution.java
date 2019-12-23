class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> wordFre = new TreeMap(Collections.reverseOrder());

        for (String word : words) {
            int key = f(word);
            wordFre.put(key, wordFre.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : wordFre.entrySet()) {
                if (entry.getKey() <= f(queries[i])) {
                    break;
                }

                count += entry.getValue();
            }

            result[i] = count;
        }

        return result;
    }

    private int f(String s) {
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int count : counts) {
            if (count != 0) {
                return count;
            }
        }

        return 0;
    }
}