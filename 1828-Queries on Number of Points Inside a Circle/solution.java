class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int r = (int) Math.pow(queries[i][2], 2);
            int count = 0;

            for (int j = 0; j < points.length; j++) {
                if (Math.pow(queries[i][0] - points[j][0], 2) + Math.pow(queries[i][1] - points[j][1], 2) <= r) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}