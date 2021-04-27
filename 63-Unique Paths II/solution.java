class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int columnNum = obstacleGrid[0].length;
        int rowNum = obstacleGrid.length;
        int[][] ways = new int[columnNum][rowNum];

        for (int i = 0; i < columnNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) {
                        ways[i][j] = obstacleGrid[j][i] == 1 ? 0
                                                             : 1;
                        continue;
                    }

                    if (i == 0) {
                        ways[i][j] = obstacleGrid[j][i] == 1 ? 0
                                                             : ways[i][j - 1];
                    }

                    if (j == 0) {
                        ways[i][j] = obstacleGrid[j][i] == 1 ? 0
                                                             : ways[i - 1][j];
                    }

                } else {
                    ways[i][j] = obstacleGrid[j][i] == 1 ? 0
                                                         : ways[i - 1][j] + ways[i][j - 1];
                }
            }
        }

        return ways[columnNum - 1][rowNum - 1];
    }
}