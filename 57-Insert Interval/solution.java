class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null) {
            return intervals;
        }

        List<int[]> result = new ArrayList();
        result.add(newInterval);

        for (int[] interval : intervals) {
            int[] last = result.get(result.size() - 1);
            if (last[1] < interval[0]) {
                result.add(interval);
                continue;
            }

            if (interval[1] < last[0]) {
                result.add(result.size() - 1, interval);
                continue;
            }

            if (interval[0] <= last[0] && interval[1] >= last[1]) {
                result.get(result.size() - 1)[0] = interval[0];
                result.get(result.size() - 1)[1] = interval[1];
                continue;
            }

            if (interval[0] <= last[1] && interval[0] > last[0] && interval[1] > last[1]) {
                result.get(result.size() - 1)[1] = interval[1];
                continue;
            }

            if (interval[0] < last[0] && interval[1] >= last[0] && interval[1] < last[1]) {
                result.get(result.size() - 1)[0] = interval[0];
                continue;
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}