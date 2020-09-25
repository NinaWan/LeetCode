class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(c, i, j, board)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char c, int row, int col, char[][] board) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == c) {
                return false;
            }

            if (board[k][col] == c) {
                return false;
            }

            if (board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == c) {
                return false;
            }
        }

        return true;
    }
}