class Solution {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        int N = grid.length;

        for (int x = 0; x < N; x++) {
            int rowMax = 0, colMax = 0;
            for (int y = 0; y < N; y++) {
                ans += grid[x][y] == 0 ? 0 : 1;// xy
                rowMax = Math.max(rowMax, grid[x][y]);// xz
                colMax = Math.max(colMax, grid[y][x]);// yz
            }
            ans += rowMax;
            ans += colMax;
        }

        return ans;
    }
}