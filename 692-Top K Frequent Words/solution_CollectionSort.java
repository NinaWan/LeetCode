class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList(freq.keySet());
        Collections.sort(list, (String a, String b) -> {
            int freqA = freq.get(a);
            int freqB = freq.get(b);

            if (freqA == freqB) {
                return a.compareTo(b);
            }

            return freqB - freqA;
        });

        List<String> ans = new ArrayList();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i));
        }

        return ans;
    }
}