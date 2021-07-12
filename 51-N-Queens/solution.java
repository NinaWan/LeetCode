class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList();
        backtrack(n, 0, ans, board);

        return ans;
    }

    private void backtrack(int n, int row, List<List<String>> res, char[][] board) {
        if (row == n) {
            res.add(toList(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';
            backtrack(n, row + 1, res, board);
            board[row][col] = '.';
        }
    }

    private List<String> toList(char[][] board) {
        List<String> res = new ArrayList();

        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }

        return res;
    }

    private boolean isValid(char[][] board, int row, int col) {
        // check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check top left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check top right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}