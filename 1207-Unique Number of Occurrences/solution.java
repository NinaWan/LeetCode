class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap();
        Set<Integer> set = new HashSet();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int f : freq.values()) {
            if (set.contains(f)) {
                return false;
            }
            set.add(f);
        }

        return true;
    }
}