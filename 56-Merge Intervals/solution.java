class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        List<int[]> result = new ArrayList();

        for (int[] interval : intervals) {
            if (result.isEmpty() || interval[0] > result.get(result.size() - 1)[1]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}