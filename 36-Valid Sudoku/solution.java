public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set rowSet = new HashSet();
            Set columnSet = new HashSet();
            for (int j = 0; j < 9; j++) {
                // check row
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j]) || !checkRank(board[i][j])) return false;
                    rowSet.add(board[i][j]);
                }
                // check column
                if (board[j][i] != '.') {
                    if (columnSet.contains(board[j][i]) || !checkRank(board[j][i])) return false;
                    columnSet.add(board[j][i]);
                }

                // check cube
                if (i % 3 == 0 && j % 3 == 0) {
                    Set cubeSet = new HashSet();
                    for (int m = i; m < i + 3; m++) {
                        for (int n = j; n < j + 3; n++) {
                            if (board[m][n] == '.') continue;
                            if (cubeSet.contains(board[m][n]) || !checkRank(board[m][n])) return false;
                            cubeSet.add(board[m][n]);
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean checkRank(char cell) {
        if ('0' < cell && cell <= '9') return true;
        return false;
    }
}