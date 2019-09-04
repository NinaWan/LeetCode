class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] answer = new int[queries.length];
        int[] wFrequency = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            wFrequency[i] = f(words[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int count = 0;
            for (int j = 0; j < wFrequency.length; j++) {
                if (f(query) < wFrequency[j]) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    private int f(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map.Entry smallest = null;

        for (Map.Entry current : frequency.entrySet()) {
            if (smallest == null || (char) (smallest.getKey()) > (char) (current.getKey())) {
                smallest = current;
            }
        }

        return (Integer) smallest.getValue();
    }
}