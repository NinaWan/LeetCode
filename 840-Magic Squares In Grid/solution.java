class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isMagicSquare(int[][] grid, int rowS, int colS) {
        // check 1~9
        int[] nums = new int[9];
        for (int i = rowS; i < rowS + 3; i++) {
            for (int j = colS; j < colS + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || nums[grid[i][j] - 1] == 1) {
                    return false;
                }
                nums[grid[i][j] - 1]++;
            }
        }

        // each row
        for (int i = rowS; i < rowS + 3; i++) {
            if (grid[rowS][colS] + grid[rowS][colS + 1] + grid[rowS][colS + 2] != 15) {
                return false;
            }
        }

        // each column
        for (int j = colS; j < colS + 3; j++) {
            if (grid[rowS][colS] + grid[rowS + 1][colS] + grid[rowS + 2][colS] != 15) {
                return false;
            }
        }

        // each diagonal
        if (grid[rowS][colS] + grid[rowS + 1][colS + 1] + grid[rowS + 2][colS + 2] != 15) {
            return false;
        }

        if (grid[rowS][colS + 2] + grid[rowS + 1][colS + 1] + grid[rowS + 2][colS] != 15) {
            return false;
        }

        return true;
    }
}