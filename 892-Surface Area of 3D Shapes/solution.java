class Solution {
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int N = grid.length;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // up and down
                ans += grid[x][y] == 0 ? 0
                                       : 2;
                // left
                ans += x == 0 ? grid[x][y]
                              : Math.max(grid[x][y] - grid[x - 1][y], 0);
                // right
                ans += x == N - 1 ? grid[x][y]
                                  : Math.max(grid[x][y] - grid[x + 1][y], 0);
                // back
                ans += y == 0 ? grid[x][y]
                              : Math.max(grid[x][y] - grid[x][y - 1], 0);
                // front
                ans += y == N - 1 ? grid[x][y]
                                  : Math.max(grid[x][y] - grid[x][y + 1], 0);
            }
        }

        return ans;
    }
}