class Solution {
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        int[] r = new int[m];
        int[] c = new int[n];

        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    temp++;
                }
                if (temp == 2) {
                    r[i] = 1;
                    break;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int temp = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    temp++;
                }
                if (temp == 2) {
                    c[j] = 1;
                    break;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (r[i] == 1 || c[j] == 1)) {
                    result++;
                }
            }
        }

        return result;
    }
}