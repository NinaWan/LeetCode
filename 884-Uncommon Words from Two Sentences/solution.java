class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> ans = new ArrayList();
        Map<String, Integer> freqA = new HashMap();
        Map<String, Integer> freqB = new HashMap();

        for (String s : A.split(" ")) {
            freqA.put(s, freqA.getOrDefault(s, 0) + 1);
        }

        for (String s : B.split(" ")) {
            freqB.put(s, freqB.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freqA.entrySet()) {
            if (entry.getValue() == 1 && !freqB.containsKey(entry.getKey())) {
                ans.add(entry.getKey());
            }
        }

        for (Map.Entry<String, Integer> entry : freqB.entrySet()) {
            if (entry.getValue() == 1 && !freqA.containsKey(entry.getKey())) {
                ans.add(entry.getKey());
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}