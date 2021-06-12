class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n]; // dp[i][j][k] - the max points from box[i] to box[j] with k boxes whose values equal to box[i] already

        return removeBoxes(boxes, 0, n - 1, 1, dp);
    }

    private int removeBoxes(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return k * k;
        }

        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }

        dp[i][j][k] = removeBoxes(boxes, i + 1, j, 1, dp) + k * k;// merge immediately
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                dp[i][j][k] = Math.max(dp[i][j][k], removeBoxes(boxes, i + 1, m - 1, 1, dp) + removeBoxes(boxes, m, j, k + 1, dp));// wait for m
            }
        }

        return dp[i][j][k];
    }
}