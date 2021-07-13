class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        if (i == board.length) {
            return true;
        }

        if (j == board.length) {
            return backtrack(board, i + 1, 0);
        }

        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, i, j, ch)) {
                continue;
            }

            board[i][j] = ch;
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }

        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        int n = board.length;

        for (int k = 0; k < n; k++) {
            // check same column
            if (board[k][col] == ch) {
                return false;
            }

            // check same row
            if (board[row][k] == ch) {
                return false;
            }

            if (board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == ch) {
                return false;
            }
        }

        return true;
    }
}