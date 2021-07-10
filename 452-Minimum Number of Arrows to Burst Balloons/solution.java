class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> a[1] == b[1] ? 0
                                                   : a[1] > b[1] ? 1
                                                                 : -1);

        int ans = 1;
        int end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                ans++;
                end = point[1];
            }
        }

        return ans;
    }
}