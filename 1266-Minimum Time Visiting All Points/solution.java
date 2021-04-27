class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;

        if (points.length == 1) {
            return 1;
        }

        int[] curr = points[0];

        for (int i = 1; i < points.length; i++) {
            int[] next = points[i];
            int xDiff = next[0] - curr[0];
            int yDiff = next[1] - curr[1];

            while (xDiff != 0 || yDiff != 0) {
                if (xDiff != 0) {
                    curr[0] += xDiff < 0 ? -1
                                         : 1;
                }

                if (yDiff != 0) {
                    curr[1] += yDiff < 0 ? -1
                                         : 1;
                }

                result++;

                xDiff = next[0] - curr[0];
                yDiff = next[1] - curr[1];
            }
        }

        return result;
    }
}