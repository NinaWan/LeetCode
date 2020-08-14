class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new TreeMap(Collections.reverseOrder());
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry entry : freq.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                return (Integer) entry.getKey();
            }
        }

        return -1;
    }
}