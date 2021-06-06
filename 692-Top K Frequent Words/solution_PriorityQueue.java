class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList(k);
        Map<String, Integer> freq = new HashMap();
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b) -> {
            int freqA = freq.get(a), freqB = freq.get(b);
            if (freqA == freqB) {
                return b.compareTo(a);
            }
            return freqA - freqB;
        });

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (String word : freq.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            ans.add(0, pq.poll());
        }

        return ans;
    }
}