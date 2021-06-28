class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = ans.get(ans.size() - 1);
            if (last[1] < curr[0]) {
                ans.add(curr);
            } else {
                last[1] = Math.max(last[1], curr[1]);
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}