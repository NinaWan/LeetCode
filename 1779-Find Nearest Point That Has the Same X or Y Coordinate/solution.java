class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int px = points[i][0];
            int py = points[i][1];
            int currDist = Math.max(Math.abs(y - py), Math.abs(x - px));
            if ((x == px || y == py) && currDist < minDist) {
                minDist = currDist;
                ans = i;
            }
        }

        return ans;
    }
}