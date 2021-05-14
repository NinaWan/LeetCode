class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> {// sort by startDay ascending, then endDay ascending
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[][] dp = new int[events.length][k + 1];// [i, j] - maximum sum of values by attending at most j events among the first i events
        for (int i = 0; i < events.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(dp, events, 0, k);
    }

    private int dfs(int[][] dp, int[][] events, int i, int k) {
        if (k == 0 || i >= events.length) {
            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        // find next events we can attend, i.e. whose startDay is greater than current event's endDay
        int left = i + 1, right = events.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > events[i][1]) {// startDay > current endDay
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return dp[i][k] = Math.max(dfs(dp, events, i + 1, k), dfs(dp, events, right, k - 1) + events[i][2]);// attend current event or not, return the
                                                                                                            // maximum one
    }
}