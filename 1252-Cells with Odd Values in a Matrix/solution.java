class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rowIncre = new int[n];
        int[] colIncre = new int[m];
        int result = 0;

        if (null == indices || indices.length == 0) {
            return 0;
        }

        for (int i = 0; i < indices.length; i++) {
            rowIncre[indices[i][0]]++;
            colIncre[indices[i][1]]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((rowIncre[i] + colIncre[j]) % 2 == 1) {
                    result++;
                }
            }
        }

        return result;
    }
}