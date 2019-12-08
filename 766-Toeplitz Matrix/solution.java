class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int r = 0; r < row - 1; r++) {
            for (int c = 0; c < col - 1; c++) {
                if (matrix[r][c] != matrix[r + 1][c + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}