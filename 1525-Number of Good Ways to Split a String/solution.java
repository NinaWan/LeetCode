class Solution {
    public int numSplits(String s) {
        if (s.length() == 1) {
            return 0;
        }

        int result = 0;
        Set<Character> p = new HashSet();
        Set<Character> q = new HashSet();
        Map<Character, Integer> freq = new HashMap();

        for (Character c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            q.add(c);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            Character c = s.charAt(i);
            p.add(c);
            freq.put(c, freq.get(c) - 1);
            if (freq.get(c) == 0) {
                q.remove(c);
            }
            if (p.size() == q.size()) {
                result++;
            }
        }

        return result;
    }
}