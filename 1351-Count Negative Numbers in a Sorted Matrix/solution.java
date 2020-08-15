class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] < 0) {
                    result += grid[0].length - c;
                    break;
                }
            }
        }

        return result;
    }
}