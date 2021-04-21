class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        long[] preSum = new long[candiesCount.length];
        preSum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            preSum[i] = preSum[i - 1] + candiesCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0], day = queries[i][1], cap = queries[i][2];
            long earliest = type == 0 ? 0
                                      : preSum[type - 1] / cap;
            long latest = preSum[type] - 1;
            if (day <= latest && day >= earliest) {
                ans[i] = true;
            }
        }

        return ans;
    }
}