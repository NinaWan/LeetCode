class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int countOne = 0;

                if (r > 0) {
                    countOne += Math.abs(board[r - 1][c]) == 1 ? 1 : 0;
                    countOne += c > 0 && Math.abs(board[r - 1][c - 1]) == 1 ? 1 : 0;
                    countOne += c < board[0].length - 1 && Math.abs(board[r - 1][c + 1]) == 1 ? 1 : 0;
                }

                if (r < board.length - 1) {
                    countOne += Math.abs(board[r + 1][c]) == 1 ? 1 : 0;
                    countOne += c > 0 && Math.abs(board[r + 1][c - 1]) == 1 ? 1 : 0;
                    countOne += c < board[0].length - 1 && Math.abs(board[r + 1][c + 1]) == 1 ? 1 : 0;
                }

                countOne += c > 0 && Math.abs(board[r][c - 1]) == 1 ? 1 : 0;
                countOne += c < board[0].length - 1 && Math.abs(board[r][c + 1]) == 1 ? 1 : 0;

                if (board[r][c] == 1) {
                    if (countOne < 2 || countOne > 3) {
                        board[r][c] = -1;
                    }
                } else {
                    if (countOne == 3) {
                        board[r][c] = 2;
                    }
                }
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = board[r][c] == 2 ? 1 : board[r][c] == -1 ? 0 : board[r][c];
            }
        }
    }
}