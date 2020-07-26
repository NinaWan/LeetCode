class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, TreeMap<Integer, Integer>> sumIndexes = new TreeMap();
        int resSize = 0;

        for (int r = 0; r < nums.size(); r++) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                int sum = r + c;
                TreeMap<Integer, Integer> tmp = sumIndexes.getOrDefault(sum, new TreeMap<Integer, Integer>());
                tmp.put(c, r);
                sumIndexes.put(sum, tmp);
                resSize++;
            }
        }

        int[] result = new int[resSize];
        int i = 0;

        for (TreeMap<Integer, Integer> indexes : sumIndexes.values()) {
            for (Map.Entry entry : indexes.entrySet()) {
                result[i] = nums.get((int) entry.getValue()).get((int) entry.getKey());
                i++;
            }
        }

        return result;
    }
}