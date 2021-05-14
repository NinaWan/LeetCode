class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(intervals[entry.getValue()][1]);
            ans[entry.getValue()] = ceiling == null ? -1
                                                    : ceiling.getValue();
        }

        return ans;
    }
}