class Solution {
    public String frequencySort(String s) {
        String ans = "";
        Map<Character, Integer> freq = new HashMap();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList(freq.keySet());
        Collections.sort(list, (a, b) -> {
            return freq.get(b) - freq.get(a);
        });

        for (char c : list) {
            for (int i = 0; i < freq.get(c); i++) {
                ans += String.valueOf(c);
            }
        }

        return ans;
    }
}