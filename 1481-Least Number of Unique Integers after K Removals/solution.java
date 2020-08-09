class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k == arr.length) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        while (k > 0) {
            Map.Entry<Integer, Integer> entry = sortedMap.entrySet().iterator().next();
            if (k >= entry.getValue()) {
                sortedMap.remove(entry.getKey());
            }
            k -= entry.getValue();
        }

        return sortedMap.keySet().size();
    }
}