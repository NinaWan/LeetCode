class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        Map<Integer, List<Integer>> map = new TreeMap();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList());
            list.add(i);
            map.put(arr[i], list);
        }

        int rank = 1;
        for (List<Integer> indexes : map.values()) {
            for (Integer index : indexes) {
                result[index] = rank;
            }
            rank++;
        }

        return result;
    }
}