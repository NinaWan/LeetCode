class Solution {
    public int numRookCaptures(char[][] board) {
        int result = 0;

        int r = 0, c = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }

        // North
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'p' || board[i][c] == 'B') {
                result += board[i][c] == 'p' ? 1 : 0;
                break;
            }
        }

        // South
        for (int i = r + 1; i < 8; i++) {
            if (board[i][c] == 'p' || board[i][c] == 'B') {
                result += board[i][c] == 'p' ? 1 : 0;
                break;
            }
        }

        // West
        for (int j = c - 1; j >= 0; j--) {
            if (board[r][j] == 'p' || board[r][j] == 'B') {
                result += board[r][j] == 'p' ? 1 : 0;
                break;
            }
        }

        // East
        for (int j = c + 1; j < 8; j++) {
            if (board[r][j] == 'p' || board[r][j] == 'B') {
                result += board[r][j] == 'p' ? 1 : 0;
                break;
            }
        }

        return result;
    }
}