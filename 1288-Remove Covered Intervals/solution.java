class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = intervals.length, res = 0;
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][1] <= right) {
                res++;
            } else if (intervals[i][0] <= right) {
                right = intervals[i][1];
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        return n - res;
    }
}