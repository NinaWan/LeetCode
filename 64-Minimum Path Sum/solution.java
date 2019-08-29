class Solution {
    public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        int columnNum = grid[0].length;
        int[][] minPaths = new int[rowNum][columnNum];

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (i == 0 && j == 0) {
                    minPaths[i][j] = grid[i][j];
                    continue;
                }

                if (i == 0) {
                    minPaths[i][j] = grid[i][j] + minPaths[i][j - 1];
                }

                if (j == 0) {
                    minPaths[i][j] = grid[i][j] + minPaths[i - 1][j];
                }

                if (i != 0 && j != 0) {
                    minPaths[i][j] = grid[i][j] + Math.min(minPaths[i - 1][j], minPaths[i][j - 1]);
                }
            }
        }

        return minPaths[rowNum - 1][columnNum - 1];
    }
}