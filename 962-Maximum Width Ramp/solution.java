class Solution {
    public int maxWidthRamp(int[] A) {
        int result = 0;
        Map<Integer, List<Integer>> tmap = new TreeMap();
        for (int i = 0; i < A.length; i++) {
            List<Integer> indexes = tmap.getOrDefault(A[i], new ArrayList());
            indexes.add(i);
            tmap.put(A[i], indexes);
        }

        int minIndex = -1;
        List<Integer> orderedIndexes = tmap.values().stream().flatMap(List::stream).collect(Collectors.toList());
        for (int index : orderedIndexes) {
            if (minIndex == -1 || index < minIndex) {
                minIndex = index;
                continue;
            }

            result = Math.max(result, index - minIndex);
        }

        return result;
    }
}