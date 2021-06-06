class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1, minDist = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            if (x1 == x || y1 == y) {
                int dist = Math.abs(x1 - x) + Math.abs(y1 - y);
                if (dist < minDist) {
                    minDist = dist;
                    ans = i;
                }
            }
        }

        return ans;
    }
}