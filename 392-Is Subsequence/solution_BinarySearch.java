class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> idxes = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            List<Integer> list = idxes.getOrDefault(c, new ArrayList());
            list.add(i);
            idxes.put(c, list);
        }

        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!idxes.containsKey(c)) {
                return false;
            }
            List<Integer> list = idxes.get(c);
            int p = Collections.binarySearch(list, pre);
            p = p < 0 ? -(p + 1) : p;
            if (p == list.size()) {
                return false;
            }
            pre = list.get(p) + 1;
        }

        return true;
    }
}