class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String processed = paragraph.replaceAll("[!;,'/?/.]", " ").toLowerCase();
        Map<String, Integer> freq = new HashMap();
        Set<String> set = new HashSet();

        for (String word : banned) {
            set.add(word);
        }

        for (String word : processed.split(" +")) {
            if (!set.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        List<String> list = new ArrayList(freq.keySet());
        Collections.sort(list, (String a, String b) -> {
            return freq.get(b) - freq.get(a);
        });

        return list.get(0);
    }
}