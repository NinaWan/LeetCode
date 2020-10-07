class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        int[][] starts = new int[intervals.length][2];

        for (int i = 0; i < intervals.length; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        Arrays.sort(starts, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        for (int i = 0; i < intervals.length; i++) {
            int target = intervals[i][1];
            int left = 0, right = starts.length - 1;
            ans[i] = -1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (starts[mid][0] >= target) {
                    ans[i] = starts[mid][1];
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (starts[right][0] >= target) {
                ans[i] = starts[right][1];
            }
        }

        return ans;
    }
}