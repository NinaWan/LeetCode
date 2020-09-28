class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int n = R * C;
        int[][] ans = new int[n][2];
        int[] curr = {r0, c0};
        ans[0][0] = curr[0];
        ans[0][1] = curr[1];
        int count = 1;
        int[] range = {c0, r0, c0, r0};

        while (count < n) {
            // move right
            range[0]++;
            while (count < n && curr[1] < range[0]) {
                curr[1]++;
                if (curr[0] >= 0 && curr[0] < R && curr[1] >= 0 && curr[1] < C) {
                    ans[count][0] = curr[0];
                    ans[count][1] = curr[1];
                    count++;
                }
            }
            // move down
            range[1]++;
            while (count < n && curr[0] < range[1]) {
                curr[0]++;
                if (curr[0] >= 0 && curr[0] < R && curr[1] >= 0 && curr[1] < C) {
                    ans[count][0] = curr[0];
                    ans[count][1] = curr[1];
                    count++;
                }
            }
            // move left
            range[2]--;
            while (count < n && curr[1] > range[2]) {
                curr[1]--;
                if (curr[0] >= 0 && curr[0] < R && curr[1] >= 0 && curr[1] < C) {
                    ans[count][0] = curr[0];
                    ans[count][1] = curr[1];
                    count++;
                }
            }
            // move up
            range[3]--;
            while (count < n && curr[0] > range[3]) {
                curr[0]--;
                if (curr[0] >= 0 && curr[0] < R && curr[1] >= 0 && curr[1] < C) {
                    ans[count][0] = curr[0];
                    ans[count][1] = curr[1];
                    count++;
                }
            }
        }

        return ans;
    }
}